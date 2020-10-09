package org.icehockey;

import model.HockeyContext;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.BeforeClass;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JSONControllerTest {

    @Test
    public void readJSONTest() {
        JSONObject leagueJSON = JSONControllerMock.getJSON(1);
        assertTrue(leagueJSON != null);
        assertEquals(leagueJSON.get("leagueName"),"Dalhousie Hockey League");
    }
}