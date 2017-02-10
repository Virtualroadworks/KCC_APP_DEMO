package com.example.laptop.truckmanv5;

import java.util.HashMap;
import java.util.Map;

public class AT_RiskAssessment_model {


    private String user_name;
    private String user_email;
    private String user_department_area;
    private String user_contact_number;
    private String startDate;
    private String endDate;

    private String traffic_ppe;
    private String traffic_roads_or_footpath;
    private String traffic_following_guidelines;
    private String traffic_beacons;
    private String traffic_left_site_in_good_order;

    private String heights_fall_arrest_system;
    private String heights_harness_inspection;
    private String heights_ladder_inspection;
    private String heights_laddertied;
    private String heights_manholebarrier;



    //////////////////////////////////////////////////////////////////////////////////

    private String raform_trafficroads;
    private String raform_trafficfootpath;
    private String raform_traffictmpguidelines_yes;
    private String raform_traffictmpguidelines_no;
    private String raform_trafficbeacon_yes;
    private String raform_trafficbeacon_no;
    private String raform_trafficleftsite_yes;
    private String raform_trafficleftsite_no;

    private String raform_trafficfallsystem_yes;
    private String raform_trafficfallsystem_no;
    private String raform_heights_harnessinspect_yes;
    private String raform_heights_harnessinspect_no;
    private String raform_heights_ladderinspect_yes;
    private String raform_heights_ladderinspect_no;
    private String raform_heights_laddertie_yes;
    private String raform_heights_laddertie_no;
    private String raform_heights_manholebarriier_yes;
    private String raform_heights_manholebarriier_no;

    //////////////////////////////////////////////////////////////////////////////////

    public AT_RiskAssessment_model () {
    }


    //////////////////////////////////////////////////////////////////////////////////

    public void settraffic_ppe(String traffic_ppe) {
        this.traffic_ppe = traffic_ppe;
    }
    public String gettraffic_ppe() {
        return traffic_ppe;
    }

    public void settraffic_roads_or_footpath(String traffic_roads_or_footpath) {
        this.traffic_roads_or_footpath = traffic_roads_or_footpath;
    }
    public String gettraffic_roads_or_footpath() {
        return traffic_roads_or_footpath;
    }


    public String getraform_trafficroads() {
        return raform_trafficroads;
    }
    public void setraform_trafficfootpath(String raform_trafficfootpath) {
        this.raform_trafficfootpath = raform_trafficfootpath;
    }
    public String getraform_trafficfootpath() {
        return raform_trafficfootpath;
    }
    public void setraform_traffictmpguidelines_yes(String raform_traffictmpguidelines_yes) {
        this.raform_traffictmpguidelines_yes = raform_traffictmpguidelines_yes;
    }
    public String getraform_traffictmpguidelines_yes() {
        return raform_traffictmpguidelines_yes;
    }
    public void setraform_traffictmpguidelines_no(String raform_traffictmpguidelines_no) {
        this.raform_traffictmpguidelines_no = raform_traffictmpguidelines_no;
    }
    public String getraform_traffictmpguidelines_no() {
        return raform_traffictmpguidelines_no;
    }
    public void setraform_trafficbeacon_yes(String raform_trafficbeacon_yes) {
        this.raform_trafficbeacon_yes = raform_trafficbeacon_yes;
    }
    public String getraform_trafficbeacon_yes() {
        return raform_trafficbeacon_yes;
    }
    public void setraform_trafficbeacon_no(String raform_trafficbeacon_no) {
        this.raform_trafficbeacon_no = raform_trafficbeacon_no;
    }
    public String getraform_trafficbeacon_no() {
        return raform_trafficbeacon_no;
    }
    public void setraform_trafficleftsite_yes(String raform_trafficleftsite_yes) {
        this.raform_trafficleftsite_yes = raform_trafficleftsite_yes;
    }
    public String getraform_trafficleftsite_yes() {
        return raform_trafficleftsite_yes;
    }
    public void setraform_trafficleftsite_no(String raform_trafficleftsite_no) {
        this.raform_trafficleftsite_no = raform_trafficleftsite_no;
    }
    public String getraform_trafficleftsite_no() {
        return raform_trafficleftsite_no;
    }

    public void setraform_trafficfallsystem_yes(String raform_trafficfallsystem_yes) {
        this.raform_trafficfallsystem_yes = raform_trafficfallsystem_yes;
    }
    public String getraform_trafficfallsystem_yes() {
        return raform_trafficfallsystem_yes;
    }
    public void setraform_trafficfallsystem_no(String raform_trafficfallsystem_no) {
        this.raform_trafficfallsystem_no = raform_trafficfallsystem_no;
    }
    public String getraform_trafficfallsystem_no() {
        return raform_trafficfallsystem_no;
    }

    public void setraform_heights_harnessinspect_yes(String raform_heights_harnessinspect_yes) {
        this.raform_heights_harnessinspect_yes = raform_heights_harnessinspect_yes;
    }
    public String getraform_heights_harnessinspect_yes() {
        return raform_heights_harnessinspect_yes;
    }
    public void setraform_heights_harnessinspect_no(String raform_heights_harnessinspect_no) {
        this.raform_heights_harnessinspect_no = raform_heights_harnessinspect_no;
    }
    public String getraform_heights_harnessinspect_no() {
        return raform_heights_harnessinspect_no;
    }
    public void setraform_heights_ladderinspect_yes(String raform_heights_ladderinspect_yes) {
        this.raform_heights_ladderinspect_yes = raform_heights_ladderinspect_yes;
    }
    public String getraform_heights_ladderinspect_yes() {
        return raform_heights_ladderinspect_yes;
    }
    public void setraform_heights_ladderinspect_no(String raform_heights_ladderinspect_no) {
        this.raform_heights_ladderinspect_no = raform_heights_ladderinspect_no;
    }
    public String getraform_heights_ladderinspect_no() {
        return raform_heights_ladderinspect_no;
    }
    public void setraform_heights_laddertie_yes(String raform_heights_laddertie_yes) {
        this.raform_heights_laddertie_yes = raform_heights_laddertie_yes;
    }
    public String getraform_heights_laddertie_yes() {
        return raform_heights_laddertie_yes;
    }
    public void setraform_heights_laddertie_no(String raform_heights_laddertie_no) {
        this.raform_heights_laddertie_no = raform_heights_laddertie_no;
    }
    public String getraform_heights_laddertie_no() {
        return raform_heights_laddertie_no;
    }
    public void setraform_heights_manholebarriier_yes(String raform_heights_manholebarriier_yes) {
        this.raform_heights_manholebarriier_yes = raform_heights_manholebarriier_yes;
    }
    public String getraform_heights_manholebarriier_yes() {
        return raform_heights_manholebarriier_yes;
    }
    public void setraform_heights_manholebarriier_no(String raform_heights_manholebarriier_no) {
        this.raform_heights_manholebarriier_no = raform_heights_manholebarriier_no;
    }
    public String getraform_heights_manholebarriier_no() {
        return raform_heights_manholebarriier_no;
    }

    //////////////////////////////////////////////////////////////////////////////////


    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getuser_name() {
        return user_name;
    }

    public void setuser_email(String user_email) {
        this.user_email = user_email;
    }
    public String getuser_email() {
        return user_email;
    }

    public void setuser_department_area(String user_department_area) {
        this.user_department_area = user_department_area;
    }
    public String getuser_department_area() {
        return user_department_area;
    }

    public void setuser_contact_number(String user_contact_number) {
        this.user_contact_number = user_contact_number;
    }
    public String getuser_contact_number() {
        return user_contact_number;
    }

    public void setstartDate(String startDate) {
        this.startDate =startDate;
    }
    public String getstartDate() {
        return this.startDate;
    }

    public void setendDate(String endDate) {
        this.endDate =endDate;
    }
    public String getendDate() {
        return this.endDate;
    }


///////////////////////////////////////1 Section 1 Location/////////////////////////////////////////////////


//--------------------------------------------------------------------------------------

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("user_name", user_name);
        result.put("user_email", user_email);
        result.put("user_department_area", user_department_area);
        result.put("user_contact_number", user_contact_number);
        result.put("startDate", startDate);
        result.put("endDate", endDate);

        result.put("traffic_ppe", traffic_ppe);
        result.put("traffic_roads_or_footpath", traffic_roads_or_footpath);


//--------------------------------------------------------------------------------------



        result.put("raform_trafficroads", raform_trafficroads);
        result.put("raform_trafficfootpath", raform_trafficfootpath);
        result.put("raform_traffictmpguidelines_yes", raform_traffictmpguidelines_yes);
        result.put("raform_traffictmpguidelines_no", raform_traffictmpguidelines_no);
        result.put("raform_trafficbeacon_yes", raform_trafficbeacon_yes);
        result.put("raform_trafficbeacon_no", raform_trafficbeacon_no);
        result.put("raform_trafficleftsite_yes", raform_trafficleftsite_yes);
        result.put("raform_trafficleftsite_no", raform_trafficleftsite_no);

        result.put("raform_trafficfallsystem_yes", raform_trafficfallsystem_yes);
        result.put("raform_trafficfallsystem_no", raform_trafficfallsystem_no);

        result.put("raform_heights_harnessinspect_yes", raform_heights_harnessinspect_yes);
        result.put("raform_heights_harnessinspect_no", raform_heights_harnessinspect_no);
        result.put("raform_heights_ladderinspect_yes", raform_heights_ladderinspect_yes);
        result.put("raform_heights_ladderinspect_no", raform_heights_ladderinspect_no);
        result.put("raform_heights_laddertie_yes", raform_heights_laddertie_yes);
        result.put("raform_heights_laddertie_no", raform_heights_laddertie_no);
        result.put("raform_heights_manholebarriier_yes", raform_heights_manholebarriier_yes);
        result.put("raform_heights_manholebarriier_no", raform_heights_manholebarriier_no);


//--------------------------------------------------------------------------------------



        return result;
    }

}