package com.HW2.service;

import java.io.File;
import java.util.List;

import com.HW2.model.WeatherBean;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

public class CSVtoPOJO {
    public static List<WeatherBean> readFile(File csvFile) throws Exception {
        MappingIterator<WeatherBean> weatherIterator = new CsvMapper().readerWithTypedSchemaFor(WeatherBean.class).readValues(csvFile);

        return weatherIterator.readAll();
    }

}
