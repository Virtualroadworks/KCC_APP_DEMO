package com.example.laptop.truckmanv5;



import java.util.HashMap;
import java.util.Map;


public class AT_Confined_Space_model {

    private String user_name;
    private String user_email;
    private String user_department_area;
    private String user_contact_number;
    private String startDate;
    private String endDate;



    //////////////////////////////////////////////////////////////////////////////////

    private String csform_generalppehivisvest;
    private String csform_generalppehardhat;
    private String csform_generalppesafetyboots;
    private String csform_generalppegloves;
    private String csform_generalppeoveralls;
    private String csform_generalppeglasses;

    //////////////////////////////////////////////////////////////////////////////////

    private String csform_cs_level_1;
    private String csform_cs_level_2;
    private String csform_cs_level_3;

    public AT_Confined_Space_model () {
    }


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


    //////////////////////////////////////////////////////////////////////////////////

    public void setcsform_generalppehivisvest(String csform_generalppehivisvest) {
        this.csform_generalppehivisvest = csform_generalppehivisvest;
    }
    public String getcsform_generalppehivisvest() {
        return csform_generalppehivisvest;
    }

    public void setcsform_generalppehardhat(String csform_generalppehardhat) {
        this.csform_generalppehardhat = csform_generalppehardhat;
    }
    public String getcsform_generalppehardhat() {
        return csform_generalppehardhat;
    }

    public void setcsform_generalppesafetyboots(String csform_generalppesafetyboots) {
        this.csform_generalppesafetyboots = csform_generalppesafetyboots;
    }
    public String getcsform_generalppesafetyboots() {
        return csform_generalppesafetyboots;
    }

    public void setcsform_generalppegloves(String csform_generalppegloves) {
        this.csform_generalppegloves = csform_generalppegloves;
    }
    public String getcsform_generalppegloves() {
        return csform_generalppegloves;
    }

    public void setcsform_generalppeoveralls(String csform_generalppeoveralls) {
        this.csform_generalppeoveralls = csform_generalppeoveralls;
    }
    public String getcsform_generalppeoveralls() {
        return csform_generalppeoveralls;
    }

    public void setcsform_generalppeglasses(String csform_generalppeglasses) {
        this.csform_generalppeglasses = csform_generalppeglasses;
    }
    public String getcsform_generalppeglasses() {
        return csform_generalppeglasses;
    }


    //////////////////////////////////////////////////////////////////////////////////

    public void setcsform_cs_level_1(String csform_cs_level_1) {
        this.csform_cs_level_1 = csform_cs_level_1;
    }
    public String getcsform_cs_level_1() {
        return csform_cs_level_1;
    }

    public void setcsform_cs_level_2(String csform_cs_level_2) {
        this.csform_cs_level_2 = csform_cs_level_2;
    }
    public String getcsform_cs_level_2() {
        return csform_cs_level_2;
    }

    public void setcsform_cs_level_3(String csform_cs_level_3) {
        this.csform_cs_level_3 = csform_cs_level_3;
    }
    public String getcsform_cs_level_3() {
        return csform_cs_level_3;
    }



    //////////////////////////////////////////////////////////////////////////////////



//--------------------------------------------------------------------------------------

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("user_name", user_name);
        result.put("user_email", user_email);
        result.put("user_department_area", user_department_area);
        result.put("user_contact_number", user_contact_number);
        result.put("startDate", startDate);
        result.put("endDate", endDate);

//--------------------------------------------------------------------------------------


        result.put("csform_generalppehivisvest", csform_generalppehivisvest);
        result.put("csform_generalppehardhat", csform_generalppehardhat);
        result.put("csform_generalppesafetyboots", csform_generalppesafetyboots);
        result.put("csform_generalppegloves", csform_generalppegloves);
        result.put("csform_generalppeoveralls", csform_generalppeoveralls);
        result.put("csform_generalppeglasses", csform_generalppeglasses);

//--------------------------------------------------------------------------------------

        result.put("csform_cs_level_1", csform_cs_level_1);
        result.put("csform_cs_level_2", csform_cs_level_2);
        result.put("csform_cs_level_3", csform_cs_level_3);

//--------------------------------------------------------------------------------------



        return result;
    }

}