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

    private String cs_overalls;
    private String cs_gasmonitor;
    private String cs_emergencycall;
    private String cs_firstaid;
    private String cs_explosivelight;
    private String cs_safetysigns;
    private String cs_isolationsources;
    private String cs_lifejacket;
    private String cs_bumphat;
    private String cs_escapeset;
    private String cs_tripodharness;
    private String cs_communication;
    private String cs_rescue;



    //////////////////////////////////////////////////////////////////////////////////

    public AT_Confined_Space_model () {
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

    public void setcs_overalls(String cs_overalls) {
        this.cs_overalls = cs_overalls;
    }
    public String getcs_overalls() {
        return cs_overalls;
    }
    public void setcs_gasmonitor(String cs_gasmonitor) {
        this.cs_gasmonitor = cs_gasmonitor;
    }
    public String getcs_gasmonitor() {
        return cs_gasmonitor;
    }
    public void setcs_emergencycall(String cs_emergencycall) {
        this.cs_emergencycall = cs_emergencycall;
    }
    public String getcs_emergencycall() {
        return cs_emergencycall;
    }
    public void setcs_firstaid(String cs_firstaid) {
        this.cs_firstaid = cs_firstaid;
    }
    public String getcs_firstaid() {
        return cs_firstaid;
    }
    public void setcs_explosivelight(String cs_explosivelight) {
        this.cs_explosivelight = cs_explosivelight;
    }
    public String getcs_explosivelight() {
        return cs_explosivelight;
    }
    public void setcs_safetysigns(String cs_safetysigns) {
        this.cs_safetysigns = cs_safetysigns;
    }
    public String getcs_safetysigns() {
        return cs_safetysigns;
    }
    public void setcs_isolationsources(String cs_isolationsources) {
        this.cs_isolationsources = cs_isolationsources;
    }
    public String getcs_isolationsources() {
        return cs_isolationsources;
    }
    public void setcs_lifejacket(String cs_lifejacket) {
        this.cs_lifejacket = cs_lifejacket;
    }
    public String getcs_lifejacket() {
        return cs_lifejacket;
    }
    public void setcs_bumphat(String cs_bumphat) {
        this.cs_bumphat = cs_bumphat;
    }
    public String getcs_bumphat() {
        return cs_bumphat;
    }
    public void setcs_escapeset(String cs_escapeset) {
        this.cs_escapeset = cs_escapeset;
    }
    public String getcs_escapeset() {
        return cs_escapeset;
    }
    public void setcs_tripodharness(String cs_tripodharness) {
        this.cs_tripodharness = cs_tripodharness;
    }
    public String getcs_tripodharness() {
        return cs_tripodharness;
    }
    public void setcs_communication(String cs_communication) {
        this.cs_communication = cs_communication;
    }
    public String getcs_communication() {
        return cs_communication;
    }
    public void setcs_rescue(String cs_rescue) {
        this.cs_rescue = cs_rescue;
    }
    public String getcs_rescue() {
        return cs_rescue;
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

        result.put("cs_overalls", cs_overalls);
        result.put("cs_gasmonitor", cs_gasmonitor);
        result.put("cs_emergencycall", cs_emergencycall);
        result.put("cs_firstaid", cs_firstaid);
        result.put("cs_explosivelight", cs_explosivelight);
        result.put("cs_safetysigns", cs_safetysigns);
        result.put("cs_isolationsources", cs_isolationsources);
        result.put("cs_lifejacket", cs_lifejacket);
        result.put("cs_bumphat", cs_bumphat);
        result.put("cs_escapeset", cs_escapeset);
        result.put("cs_tripodharness", cs_tripodharness);
        result.put("cs_communication", cs_communication);
        result.put("cs_rescue", cs_rescue);



//--------------------------------------------------------------------------------------


        return result;
    }

}