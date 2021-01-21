package org.adrian.test.serialize.base64;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author xl48886
 * @version Id: Base64Test, v 0.1 2020/3/5 下午3:06 xl48886 Exp $
 */
public class Base64Test {

    @Test
    public void testDecode() {
        String msg = "eJxzNtBNzs/Vy6nUy0zVyyxOLNPLzU9JzdErSi0uyM8rTtVzLAtOTSwpDoLyp7EXlyYnpxYXs6cWFTkDlbIBad/idI7i1KKy1CLPAK7EMs+8lNQK38QCIBOsF8hMCPHz4zE0N9IzMtAzBxKGHlEeUQD41irV";
        String json = new String(Base64.decodeBase64(msg), StandardCharsets.UTF_8);
        System.out.println(json);
    }

    @Test
    public void testEncode() {
        String json = "{\"verifyDate\":\"2020-03-05 14:07:53\",\"queryEngine\":\"1T\",\"gds\":\"IBE\",\"guID\":\"TC20200305140728AD2J1JNA7T9X7FYGHK8DDC7YQBZ4A7KHAYARC8WT5SVX1SXX\",\"uniKey\":\"1T/IBE/BKKMELOW20200310/CFSY/ADT|1/SZV122/NORMAL/$//VX1SXN/4500302273\",\"sourceTag\":\"Engine\",\"flights\":[{\"orgiDestSeqID\":1,\"arrivalAirportCode\":\"HKG\",\"arrivalCityCode\":\"HKG\",\"flightCabins\":[{\"code\":\"C\",\"count\":\"3\"},{\"code\":\"D\",\"count\":\"3\"}],\"segmentSeqID\":1,\"aircode\":\"FM\",\"isCodeShare\":false,\"flightNumber\":\"0722\",\"isUnable\":true,\"operatingFlightNumber\":\"0722\",\"departureCityCode\":\"SHA\",\"isValidCabin\":true,\"bookingCabin\":\"Y\",\"departureDate\":1583634276000,\"departureAirportCode\":\"SHA\",\"operatingAirline\":\"FM\"}],\"isInvalidFlight\":false}";
        System.out.println(Base64.encodeBase64String(json.getBytes()));
    }

}
