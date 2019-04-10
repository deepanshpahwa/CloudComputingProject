package com.HW2.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.google.gson.Gson;
import com.HW2.model.WeatherDateBean;
import com.HW2.model.WeatherBean;
import com.HW2.service.WeatherService;
@Path("/")
public class Controller {

    WeatherService service = new WeatherService();

    
	@GET
	@Path("/hello")
	public String getDate() {
		return "hello";

	}
    
    
    
    
    
	@GET
	@Path("/historical")
	@Produces(MediaType.APPLICATION_JSON)
	public List<WeatherDateBean> getDates() throws Exception {
        List<WeatherBean> weather;
        weather = getPojoDataFromService();


        List<WeatherDateBean> listOfDates = new ArrayList<>();
        for (WeatherBean _weather : weather){
            listOfDates.add(new WeatherDateBean(_weather.getDATE()));
        }
//        System.out.println(":::::::::::::::"+listOfDates.get(1));

        String json = new Gson().toJson(listOfDates);
        return listOfDates;

	}
	
	@GET
	@Path("/historical/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public WeatherBean getWeatherBean(@PathParam("date") String date) throws Exception{
        checkDateLength(date);

        List<WeatherBean> weather;
        weather = getPojoDataFromService();

        for (WeatherBean _weather : weather){
            if (_weather.getDATE().equals(date)){//todo check
                return _weather;
            }
        }
		throw new WebApplicationException(404);

	}
	
	@POST
	@Path("/historical")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addInformation(WeatherBean weatherBean) throws Exception {
        getPojoDataFromService();
        service.deleteWeatherEntry(weatherBean.getDATE());
        service.addWeatherData(weatherBean.getDATE(), weatherBean.getMax_temperature(), weatherBean.getMin_temperature());




        String json = new Gson().toJson(new WeatherDateBean(weatherBean.getDATE()));
		return Response.status(201).entity(json).build();

	}
	
	@DELETE
	@Path("/historical/{date}")
	public void deleteInfo(@PathParam("date") String date) throws Exception{
        checkDateLength(date);

        getPojoDataFromService();
        service.deleteWeatherEntry(date);	}
	
	@GET
	@Path("/forecast/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<WeatherBean> getforecast(@PathParam("date") String date,@Context HttpHeaders header, 
			@Context HttpServletResponse response, @Context HttpServletRequest request) throws Exception{

        checkDateLength(date);


        List<WeatherBean> weather;
        weather = getPojoDataFromService();

        for (WeatherBean _weather : weather){
            if (_weather.getDATE().equals(date)){//todo check
                if (service.getWeeksWeather(weather.indexOf(_weather)) == null){
            		throw new WebApplicationException(404);
                }
                else{
                    return service.getWeeksWeather(weather.indexOf(_weather));
                }
            }
        }

        return null;//TODO add check on UI
	}
	
    private void checkDateLength( String date) {
        if (date.length()>8){
			throw new WebApplicationException(404);
        }
    }




    private List<WeatherBean> getPojoDataFromService() throws Exception {
        List<WeatherBean> weather;
        if (!service.hasPOJOsLoaded()) {
            weather = service.loadPojos();
        }else{
            weather = service.getPojos();
        }
        return weather;
    }

}
