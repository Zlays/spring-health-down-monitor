package it.zlays.springhealthdownmonitor.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Utils {

    public static final ObjectWriter OW = new ObjectMapper().writer().withDefaultPrettyPrinter();

    private Utils() {

    }

}
