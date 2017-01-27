package com.example.laptop.truckmanv5;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private String name;
    private String email;
    private String report_email_recipient;
    private String Reg;
    private String location_address_view;
    private String in_cab_temp_fix;
    private String in_cab_des_default;
    private String user_name;
    private String user_email;
    private String user_company;
    private String user_contact_number;
    private String endDate;
    private String startDate;
    private String winmirtempfixfill;
    private String winmirdescribedefectfill;
    private String seatbeltstempfixfill;
    private String seatbeltsdescribedefectfill;
    private String washerandwipertempfixfill;
    private String washerandwiperdescribedefectfill;
    private String horntempfixfill;
    private String horndescribedefectfill;
    private String breakwarninglighttempfixfill;
    private String breakwarninglightdescribedefectfill;
    private String gaugetempfixfill;
    private String gaugedescribedefectfill;
    private String tachotempfixfill;
    private String tachodescribedefectfill;
    private String airleakstempfixfill;
    private String airleaksdescribedefectfill;
    //Driving Inspection
    private String steeringbreakingtempfixfill;
    private String steeringbreakingdescribedefectfill;
    private String loadsecuretempfixfill;
    private String loadsecuredescribedefectfill;
    private String tachospeedotempfixfill;
    private String tachospeedodescribedefectfill;
    private String nowarninglightstempfixfill;
    private String nowarninglightsdescribedefectfill;
    //Outside Inspection
    private String taxinsurancetempfixfill;
    private String taxinsurancedescribedefectfill;
    private String wheelstyrestempfixfill;
    private String wheelstyresdescribedefectfill;
    private String lightsreflectorstempfixfill;
    private String lightsreflectorsdescribedefectfill;
    private String exhausttempfixfill;
    private String exhaustdescribedefectfill;
    private String sparetowtempfixfill;
    private String sparetowdescribedefectfill;
    private String trailerbraketempfixfill;
    private String trailerbrakedescribedefectfill;
    private String bodyguardstempfixfill;
    private String bodyguardsdescribedefectfill;
    private String landinglegtempfixfill;
    private String landinglegdescribedefectfill;
    private String regplatetempfixfill;
    private String regplatedescribedefectfill;
    private String fluidleakstempfixfill;
    private String fluidleaksdescribedefectfill;
    private String airelectrialtempfixfill;
    private String airelectrialdescribedefectfill;
    private String airsuspensiontempfixfill;
    private String airsuspensiondescribedefectfill;
    //url address
    private String taxinsurancepictureuri;
    private String taxinsurancepicturepath;
    private String regplatepictureuri;
    private String regplatepicturepath;
    private String airelectrialpictureuri;
    private String fluidleakspictureuri;
    private String airsuspensionpictureuri;
    private String wheelsandtyrespictureuri;
    private String lightsreflectorspictureuri;
    private String exhaustpictureuri;
    private String bodyguardspictureuri;
    private String landinglegpictureuri;
    private String sparetowpictureuri;
    private String trailerbrakepictureuri;

    private String winmirpictureuri;
    private String seatbeltspictureuri;
    private String washerandwiperpictureuri;
    private String hornpictureuri;
    private String breakwarninglightpictureuri;
    private String gaugepictureuri;
    private String tachopictureuri;
    private String airleakspictureuri;

    private String steeringbreakingpictureuri;
    private String loadsecurepictureuri;
    private String tachospeedopictureuri;
    private String nowarninglightspictureuri;

    private String vehiclephotopictureuri;

    private String airelectrialpicturepath;
    private String fluidleakspicturepath;
    private String airsuspensionpicturepath;
    private String wheelsandtyrespicturepath;
    private String lightsreflectorspicturepath;
    private String exhaustpicturepath;
    private String bodyguardspicturepath;
    private String landinglegpicturepath;
    private String sparetowpicturepath;
    private String trailerbrakepicturepath;

    private String winmirpicturepath;
    private String seatbeltspicturepath;
    private String washerandwiperpicturepath;
    private String hornpicturepath;
    private String breakwarninglightpicturepath;
    private String gaugepicturepath;
    private String tachopicturepath;
    private String airleakspicturepath;

    private String steeringbreakingpicturepath;
    private String loadsecurepicturepath;
    private String tachospeedopicturepath;
    private String nowarninglightspicturepath;

    private String vehiclephotopicturepath;

    private String locationlat;
    private String locationlong;

    //////////////////////////////////////////////////////////////////////////////////


    public Person(){
        /*Blank default constructor essential for Firebase*/
    }

    public void setendDate(String endDate) {
        this.endDate = endDate;};
    public String getendDate() { return
            this.endDate;};
    public void setstartDate(String startDate) {
        this.startDate =startDate;
    }
    public String getstartDate() {
        return this.startDate;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNEmail() {
        return name;
    }

    public void setreport_email_recipient(String report_email_recipient) {
        this.report_email_recipient = report_email_recipient;
    }
    public String getreport_email_recipient() {
        return report_email_recipient;
    }

    public void setReg(String Reg) {
        this.Reg = Reg;
    }
    public String getReg() {
        return Reg;
    }
    public void setlocation_address_view(String location_address_view) {
        this.location_address_view = location_address_view;
    }
    public String getlocation_address_view() {
        return location_address_view;
    }
    public void setin_cab_temp_fix(String in_cab_temp_fix) {
        this.in_cab_temp_fix = in_cab_temp_fix;
    }
    public String getin_cab_temp_fix() {
        return in_cab_temp_fix;
    }
    public void setin_cab_des_default(String in_cab_des_default) {
        this.in_cab_des_default = in_cab_des_default;
    }
    public String getin_cab_des_default() {
        return in_cab_des_default;
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
    public void setuser_company(String user_company) {
        this.user_company = user_company;
    }
    public String getuser_company() { return user_company;}
    public void setuser_contact_number(String user_contact_number) {
        this.user_contact_number = user_contact_number;}
    public String getuser_contact_number() {
        return user_contact_number;
    }

    public void setwinmirtempfixfill(String winmirtempfixfill) {
        this.winmirtempfixfill = winmirtempfixfill;
    }
    public String getwinmirtempfixfill() {
        return winmirtempfixfill;
    }
    public void setwinmirdescribedefectfill(String winmirdescribedefectfill) {
        this.winmirdescribedefectfill = winmirdescribedefectfill;
    }
    public String getwinmirdescribedefectfill() {
        return winmirdescribedefectfill;
    }

    public void setseatbeltstempfixfill(String seatbeltstempfixfill) {
        this.seatbeltstempfixfill = seatbeltstempfixfill;
    }
    public String getseatbeltstempfixfill() {
        return seatbeltstempfixfill;
    }
    public void setseatbeltsdescribedefectfill(String seatbeltsdescribedefectfill) {
        this.seatbeltsdescribedefectfill = seatbeltsdescribedefectfill;
    }
    public String getseatbeltsdescribedefectfill() {
        return seatbeltsdescribedefectfill;
    }

    public void setwasherandwipertempfixfill(String washerandwipertempfixfill) {
        this.washerandwipertempfixfill = washerandwipertempfixfill;
    }
    public String getwasherandwipertempfixfill() {
        return washerandwipertempfixfill;
    }
    public void setwasherandwiperdescribedefectfill(String washerandwiperdescribedefectfill) {
        this.washerandwiperdescribedefectfill = washerandwiperdescribedefectfill;
    }
    public String getwasherandwiperdescribedefectfill() {
        return washerandwiperdescribedefectfill;
    }
    public void sethorntempfixfill(String horntempfixfill) {
        this.horntempfixfill = horntempfixfill;
    }
    public String gethorntempfixfill() {
        return horntempfixfill;
    }
    public void sethorndescribedefectfill(String horndescribedefectfill) {
        this.horndescribedefectfill = horndescribedefectfill;
    }
    public String gethorndescribedefectfill() {
        return horndescribedefectfill;
    }
    public void setbreakwarninglighttempfixfill(String breakwarninglighttempfixfill) {
        this.breakwarninglighttempfixfill = breakwarninglighttempfixfill;
    }
    public String getbreakwarninglighttempfixfill() {
        return breakwarninglighttempfixfill;
    }
    public void setbreakwarninglightdescribedefectfill(String breakwarninglightdescribedefectfill) {
        this.breakwarninglightdescribedefectfill = breakwarninglightdescribedefectfill;
    }
    public String getbreakwarninglightdescribedefectfill() {
        return breakwarninglightdescribedefectfill;
    }
    public void setgaugetempfixfill(String gaugetempfixfill) {
        this.gaugetempfixfill = gaugetempfixfill;
    }
    public String getgaugetempfixfill() {
        return gaugetempfixfill;
    }
    public void setgaugedescribedefectfill(String gaugedescribedefectfill) {
        this.gaugedescribedefectfill = gaugedescribedefectfill;
    }
    public String getgaugedescribedefectfill() {
        return gaugedescribedefectfill;
    }
    public void settachotempfixfill(String tachotempfixfill) {
        this.tachotempfixfill = tachotempfixfill;
    }
    public String gettachotempfixfill() {
        return tachotempfixfill;
    }
    public void settachodescribedefectfill(String tachodescribedefectfill) {
        this.tachodescribedefectfill = tachodescribedefectfill;
    }
    public String gettachodescribedefectfill() {
        return tachodescribedefectfill;
    }
    public void setairleakstempfixfill(String airleakstempfixfill) {
        this.airleakstempfixfill = airleakstempfixfill;
    }
    public String getairleakstempfixfill() {
        return airleakstempfixfill;
    }
    public void setairleaksdescribedefectfill(String airleaksdescribedefectfill) {
        this.airleaksdescribedefectfill = airleaksdescribedefectfill;
    }
    public String getairleaksdescribedefectfill() {
        return airleaksdescribedefectfill;
    }

    //Driving Inspection

    public void setsteeringbreakingtempfixfill(String steeringbreakingtempfixfill) {
        this.steeringbreakingtempfixfill = steeringbreakingtempfixfill;
    }
    public String getsteeringbreakingtempfixfill() {
        return steeringbreakingtempfixfill;
    }
    public void setsteeringbreakingdescribedefectfill(String steeringbreakingdescribedefectfill) {
        this.steeringbreakingdescribedefectfill = steeringbreakingdescribedefectfill;
    }
    public String getsteeringbreakingdescribedefectfill() {
        return steeringbreakingdescribedefectfill;
    }
    public void setloadsecuretempfixfill(String loadsecuretempfixfill) {
        this.loadsecuretempfixfill = loadsecuretempfixfill;
    }
    public String getloadsecuretempfixfill() {
        return loadsecuretempfixfill;
    }
    public void setloadsecuredescribedefectfill(String loadsecuredescribedefectfill) {
        this.loadsecuredescribedefectfill = loadsecuredescribedefectfill;
    }
    public String getloadsecuredescribedefectfill() {
        return loadsecuredescribedefectfill;
    }
    public void settachospeedotempfixfill(String tachospeedotempfixfill) {
        this.tachospeedotempfixfill = tachospeedotempfixfill;
    }
    public String gettachospeedotempfixfill() {
        return tachospeedotempfixfill;
    }
    public void settachospeedodescribedefectfill(String tachospeedodescribedefectfill) {
        this.tachospeedodescribedefectfill = tachospeedodescribedefectfill;
    }
    public String gettachospeedodescribedefectfill() {
        return tachospeedodescribedefectfill;
    }
    public void setnowarninglightstempfixfill(String nowarninglightstempfixfill) {
        this.nowarninglightstempfixfill = nowarninglightstempfixfill;
    }
    public String getnowarninglightstempfixfill() {
        return nowarninglightstempfixfill;
    }
    public void setnowarninglightsdescribedefectfill(String nowarninglightsdescribedefectfill) {
        this.nowarninglightsdescribedefectfill = nowarninglightsdescribedefectfill;
    }
    public String getnowarninglightsdescribedefectfill() {
        return nowarninglightsdescribedefectfill;
    }

    //Outside Inspection

    public void settaxinsurancetempfixfill(String taxinsurancetempfixfill) {
        this.taxinsurancetempfixfill = taxinsurancetempfixfill;
    }
    public String gettaxinsurancetempfixfill() {
        return taxinsurancetempfixfill;
    }
    public void settaxinsurancedescribedefectfill(String taxinsurancedescribedefectfill) {
        this.taxinsurancedescribedefectfill = taxinsurancedescribedefectfill;
    }
    public String gettaxinsurancedescribedefectfill() {
        return taxinsurancedescribedefectfill;
    }

    public void setwheelstyrestempfixfill(String wheelstyrestempfixfill) {
        this.wheelstyrestempfixfill = wheelstyrestempfixfill;
    }
    public String getwheelstyrestempfixfill() {
        return wheelstyrestempfixfill;
    }
    public void setwheelstyresdescribedefectfill(String wheelstyresdescribedefectfill) {
        this.wheelstyresdescribedefectfill = wheelstyresdescribedefectfill;
    }
    public String getwheelstyresdescribedefectfill() {
        return wheelstyresdescribedefectfill;
    }

    public void setlightsreflectorstempfixfill(String lightsreflectorstempfixfill) {
        this.lightsreflectorstempfixfill = lightsreflectorstempfixfill;
    }
    public String getlightsreflectorstempfixfill() {
        return lightsreflectorstempfixfill;
    }
    public void setlightsreflectorsdescribedefectfill(String lightsreflectorsdescribedefectfill) {
        this.lightsreflectorsdescribedefectfill = lightsreflectorsdescribedefectfill;
    }
    public String getlightsreflectorsdescribedefectfill() {
        return lightsreflectorsdescribedefectfill;
    }

    public void setexhausttempfixfill(String exhausttempfixfill) {
        this.exhausttempfixfill = exhausttempfixfill;
    }
    public String getexhausttempfixfill() {
        return exhausttempfixfill;
    }
    public void setexhaustdescribedefectfill(String exhaustdescribedefectfill) {
        this.exhaustdescribedefectfill = exhaustdescribedefectfill;
    }
    public String getexhaustdescribedefectfill() {
        return exhaustdescribedefectfill;
    }

    public void setsparetowtempfixfill(String sparetowtempfixfill) {
        this.sparetowtempfixfill = sparetowtempfixfill;
    }
    public String getsparetowtempfixfill() {
        return sparetowtempfixfill;
    }
    public void setsparetowdescribedefectfill(String sparetowdescribedefectfill) {
        this.sparetowdescribedefectfill = sparetowdescribedefectfill;
    }
    public String getsparetowdescribedefectfill() {
        return sparetowdescribedefectfill;
    }

    public void settrailerbraketempfixfill(String trailerbraketempfixfill) {
        this.trailerbraketempfixfill = trailerbraketempfixfill;
    }
    public String gettrailerbraketempfixfill() {
        return trailerbraketempfixfill;
    }
    public void settrailerbrakedescribedefectfill(String trailerbrakedescribedefectfill) {
        this.trailerbrakedescribedefectfill = trailerbrakedescribedefectfill;
    }
    public String gettrailerbrakedescribedefectfill() {
        return trailerbrakedescribedefectfill;
    }
    public void setbodyguardstempfixfill(String bodyguardstempfixfill) {
        this.bodyguardstempfixfill = bodyguardstempfixfill;
    }
    public String getbodyguardstempfixfill() {
        return bodyguardstempfixfill;
    }
    public void setbodyguardsdescribedefectfill(String bodyguardsdescribedefectfill) {
        this.bodyguardsdescribedefectfill = bodyguardsdescribedefectfill;
    }
    public String getbodyguardsdescribedefectfill() {
        return bodyguardsdescribedefectfill;
    }
    public void setlandinglegtempfixfill(String landinglegtempfixfill) {
        this.landinglegtempfixfill = landinglegtempfixfill;
    }
    public String getlandinglegtempfixfill() {
        return landinglegtempfixfill;
    }
    public void setlandinglegdescribedefectfill(String landinglegdescribedefectfill) {
        this.landinglegdescribedefectfill = landinglegdescribedefectfill;
    }
    public String getlandinglegdescribedefectfill() {
        return landinglegdescribedefectfill;
    }

    public void setregplatetempfixfill(String regplatetempfixfill) {
        this.regplatetempfixfill = regplatetempfixfill;
    }
    public String getregplatetempfixfill() {
        return regplatetempfixfill;
    }
    public void setregplatedescribedefectfill(String regplatedescribedefectfill) {
        this.regplatedescribedefectfill = regplatedescribedefectfill;
    }
    public String getregplatedescribedefectfill() {
        return regplatedescribedefectfill;
    }

    public void setfluidleakstempfixfill(String fluidleakstempfixfill) {
        this.fluidleakstempfixfill = fluidleakstempfixfill;
    }
    public String getfluidleakstempfixfill() {
        return fluidleakstempfixfill;
    }
    public void setfluidleaksdescribedefectfill(String fluidleaksdescribedefectfill) {
        this.fluidleaksdescribedefectfill = fluidleaksdescribedefectfill;
    }
    public String getfluidleaksdescribedefectfill() {
        return fluidleaksdescribedefectfill;
    }
    public void setairelectrialtempfixfill(String airelectrialtempfixfill) {
        this.airelectrialtempfixfill = airelectrialtempfixfill;
    }
    public String getairelectrialtempfixfill() {
        return airelectrialtempfixfill;
    }
    public void setairelectrialdescribedefectfill(String airelectrialdescribedefectfill) {
        this.airelectrialdescribedefectfill = airelectrialdescribedefectfill;
    }
    public String getairelectrialdescribedefectfill() {
        return airelectrialdescribedefectfill;
    }
    public void setairsuspensiontempfixfill(String airsuspensiontempfixfill) {
        this.airsuspensiontempfixfill = airsuspensiontempfixfill;
    }
    public String getairsuspensiontempfixfill() {
        return airsuspensiontempfixfill;
    }
    public void setairsuspensiondescribedefectfill(String airsuspensiondescribedefectfill) {
        this.airsuspensiondescribedefectfill = airsuspensiondescribedefectfill;
    }
    public String getairsuspensiondescribedefectfill() {
        return airsuspensiondescribedefectfill;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void settaxinsurancepictureuri(String taxinsurancepictureuri) {
        this.taxinsurancepictureuri = taxinsurancepictureuri;
    }
    public String gettaxinsurancepictureuri() {
        return taxinsurancepictureuri;
    }

    public void settaxinsurancepicturepath(String taxinsurancepicturepath) {
        this.taxinsurancepicturepath = taxinsurancepicturepath;
    }
    public String gettaxinsurancepicturepath() {
        return taxinsurancepicturepath;
    }

    public void setregplatepictureuri(String regplatepictureuri) {
        this.regplatepictureuri = regplatepictureuri;
    }
    public String getregplatepictureuri() {
        return regplatepictureuri;
    }
    public void setregplatepicturepath(String regplatepicturepath) {
        this.regplatepicturepath= regplatepicturepath;
    }
    public String getregplatepicturepath() {
        return regplatepicturepath;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setairelectrialpictureuri(String airelectrialpictureuri) {
        this.airelectrialpictureuri = airelectrialpictureuri;
    }
    public String getairelectrialpictureuri() {
        return airelectrialpictureuri;
    }
    public void setfluidleakspictureuri(String fluidleakspictureuri) {
        this.fluidleakspictureuri = fluidleakspictureuri;
    }
    public String getfluidleakspictureuri() {
        return fluidleakspictureuri;
    }
    public void setairsuspensionpictureuri(String airsuspensionpictureuri) {
        this.airsuspensionpictureuri = airsuspensionpictureuri;
    }
    public String getairsuspensionpictureuri() {
        return airsuspensionpictureuri;
    }
    public void setwheelsandtyrespictureuri(String wheelsandtyrespictureuri) {
        this.wheelsandtyrespictureuri = wheelsandtyrespictureuri;
    }
    public String getwheelsandtyrespictureuri() {
        return wheelsandtyrespictureuri;
    }
    public void setlightsreflectorspictureuri(String lightsreflectorspictureuri) {
        this.lightsreflectorspictureuri = lightsreflectorspictureuri;
    }
    public String getlightsreflectorspictureuri() {
        return lightsreflectorspictureuri;
    }
    public void setexhaustpictureuri(String exhaustpictureuri) {
        this.exhaustpictureuri = exhaustpictureuri;
    }
    public String getexhaustpictureuri() {
        return exhaustpictureuri;
    }
    public void setbodyguardspictureuri(String bodyguardspictureuri) {
        this.bodyguardspictureuri = bodyguardspictureuri;
    }
    public String getbodyguardspictureuri() {
        return bodyguardspictureuri;
    }
    public void setlandinglegpictureuri(String landinglegpictureuri) {
        this.landinglegpictureuri = landinglegpictureuri;
    }
    public String getlandinglegpictureuri() {
        return landinglegpictureuri;
    }
    public void setsparetowpictureuri(String sparetowpictureuri) {
        this.sparetowpictureuri = sparetowpictureuri;
    }
    public String getsparetowpictureuri() {
        return sparetowpictureuri;
    }
    public void settrailerbrakepictureuri(String trailerbrakepictureuri) {
        this.trailerbrakepictureuri = trailerbrakepictureuri;
    }
    public String gettrailerbrakepictureuri() {
        return trailerbrakepictureuri;
    }
    public void setwinmirpictureuri(String winmirpictureuri) {
        this.winmirpictureuri = winmirpictureuri;
    }
    public String getwinmirpictureuri() {
        return winmirpictureuri;
    }
    public void setseatbeltspictureuri(String seatbeltspictureuri) {
        this.seatbeltspictureuri = seatbeltspictureuri;
    }
    public String getseatbeltspictureuri() {
        return seatbeltspictureuri;
    }
    public void setwasherandwiperpictureuri(String washerandwiperpictureuri) {
        this.washerandwiperpictureuri = washerandwiperpictureuri;
    }
    public String getwasherandwiperpictureuri() {
        return washerandwiperpictureuri;
    }
    public void sethornpictureuri(String hornpictureuri) {
        this.hornpictureuri = hornpictureuri;
    }
    public String gethornpictureuri() {
        return hornpictureuri;
    }
    public void setbreakwarninglightpictureuri(String breakwarninglightpictureuri) {
        this.breakwarninglightpictureuri = breakwarninglightpictureuri;
    }
    public String getbreakwarninglightpictureuri() {
        return breakwarninglightpictureuri;
    }
    public void setgaugepictureuri(String gaugepictureuri) {
        this.gaugepictureuri = gaugepictureuri;
    }
    public String getgaugepictureuri() {
        return gaugepictureuri;
    }
    public void settachopictureuri(String tachopictureuri) {
        this.tachopictureuri = tachopictureuri;
    }
    public String gettachopictureuri() {
        return tachopictureuri;
    }
    public void setairleakspictureuri(String airleakspictureuri) {
        this.airleakspictureuri = airleakspictureuri;
    }
    public String getairleakspictureuri() {
        return airleakspictureuri;
    }
    public void setsteeringbreakingpictureuri(String steeringbreakingpictureuri) {
        this.steeringbreakingpictureuri = steeringbreakingpictureuri;
    }
    public String getsteeringbreakingpictureuri() {
        return steeringbreakingpictureuri;
    }
    public void setloadsecurepictureuri(String loadsecurepictureuri) {
        this.loadsecurepictureuri = loadsecurepictureuri;
    }
    public String getloadsecurepictureuri() {
        return loadsecurepictureuri;
    }
    public void settachospeedopictureuri(String tachospeedopictureuri) {
        this.tachospeedopictureuri = tachospeedopictureuri;
    }
    public String gettachospeedopictureuri() {
        return tachospeedopictureuri;
    }
    public void setnowarninglightspictureuri(String nowarninglightspictureuri) {
        this.nowarninglightspictureuri = nowarninglightspictureuri;
    }
    public String getnowarninglightspictureuri() {
        return nowarninglightspictureuri;
    }
    public void setvehiclephotopictureuri(String vehiclephotopictureuri) {
        this.vehiclephotopictureuri = vehiclephotopictureuri;
    }
    public String getvehiclephotopictureuri() {
        return vehiclephotopictureuri;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setairelectrialpicturepath(String airelectrialpicturepath) {
        this.airelectrialpicturepath = airelectrialpicturepath;
    }
    public String getairelectrialpicturepath() {
        return airelectrialpicturepath;
    }
    public void setfluidleakspicturepath(String fluidleakspicturepath) {
        this.fluidleakspicturepath = fluidleakspicturepath;
    }
    public String getfluidleakspicturepath() {
        return fluidleakspicturepath;
    }
    public void setairsuspensionpicturepath(String airsuspensionpicturepath) {
        this.airsuspensionpicturepath = airsuspensionpicturepath;
    }
    public String getairsuspensionpicturepath() {
        return airsuspensionpicturepath;
    }
    public void setwheelsandtyrespicturepath(String wheelsandtyrespicturepath) {
        this.wheelsandtyrespicturepath = wheelsandtyrespicturepath;
    }
    public String getwheelsandtyrespicturepath() {
        return wheelsandtyrespicturepath;
    }
    public void setlightsreflectorspicturepath(String lightsreflectorspicturepath) {
        this.lightsreflectorspicturepath = lightsreflectorspicturepath;
    }
    public String getlightsreflectorspicturepath() {
        return lightsreflectorspicturepath;
    }
    public void setexhaustpicturepath(String exhaustpicturepath) {
        this.exhaustpicturepath = exhaustpicturepath;
    }
    public String getexhaustpicturepath() {
        return exhaustpicturepath;
    }
    public void setbodyguardspicturepath(String bodyguardspicturepath) {
        this.bodyguardspicturepath = bodyguardspicturepath;
    }
    public String getbodyguardspicturepath() {
        return bodyguardspicturepath;
    }
    public void setlandinglegpicturepath(String landinglegpicturepath) {
        this.landinglegpicturepath = landinglegpicturepath;
    }
    public String getlandinglegpicturepath() {
        return landinglegpictureuri;
    }
    public void setsparetowpicturepath(String sparetowpicturepath) {
        this.sparetowpicturepath = sparetowpicturepath;
    }
    public String getsparetowpicturepath() {
        return sparetowpicturepath;
    }
    public void settrailerbrakepicturepath(String trailerbrakepicturepath) {
        this.trailerbrakepicturepath = trailerbrakepicturepath;
    }
    public String gettrailerbrakepicturepath() {
        return trailerbrakepicturepath;
    }
    public void setwinmirpicturepath(String winmirpicturepath) {
        this.winmirpicturepath = winmirpicturepath;
    }
    public String getwinmirpicturepath() {
        return winmirpicturepath;
    }
    public void setseatbeltspicturepath(String seatbeltspicturepath) {
        this.seatbeltspicturepath = seatbeltspicturepath;
    }
    public String getseatbeltspicturepath() {
        return seatbeltspicturepath;
    }
    public void setwasherandwiperpicturepath(String washerandwiperpicturepath) {
        this.washerandwiperpicturepath = washerandwiperpicturepath;
    }
    public String getwasherandwiperpicturepath() {
        return washerandwiperpicturepath;
    }
    public void sethornpicturepath(String hornpicturepath) {
        this.hornpicturepath = hornpicturepath;
    }
    public String gethornpicturepath() {
        return hornpicturepath;
    }
    public void setbreakwarninglightpicturepath(String breakwarninglightpicturepath) {
        this.breakwarninglightpicturepath = breakwarninglightpicturepath;
    }
    public String getbreakwarninglightpicturepath() {
        return breakwarninglightpicturepath;
    }
    public void setgaugepicturepath(String gaugepicturepath) {
        this.gaugepicturepath = gaugepicturepath;
    }
    public String getgaugepicturepath() {
        return gaugepicturepath;
    }
    public void settachopicturepath(String tachopicturepath) {
        this.tachopicturepath = tachopicturepath;
    }
    public String gettachopicturepath() {
        return tachopicturepath;
    }
    public void setairleakspicturepath(String airleakspicturepath) {
        this.airleakspicturepath = airleakspicturepath;
    }
    public String getairleakspicturepath() {
        return airleakspicturepath;
    }
    public void setsteeringbreakingpicturepath(String steeringbreakingpicturepath) {
        this.steeringbreakingpicturepath = steeringbreakingpicturepath;
    }
    public String getsteeringbreakingpicturepath() {
        return steeringbreakingpicturepath;
    }
    public void setloadsecurepicturepath(String loadsecurepicturepath) {
        this.loadsecurepicturepath = loadsecurepicturepath;
    }
    public String getloadsecurepicturepath() {
        return loadsecurepicturepath;
    }
    public void settachospeedopicturepath(String tachospeedopicturepath) {
        this.tachospeedopicturepath= tachospeedopicturepath;
    }
    public String gettachospeedopicturepath() {
        return tachospeedopicturepath;
    }
    public void setnowarninglightspicturepath(String nowarninglightspicturepath) {
        this.nowarninglightspicturepath = nowarninglightspicturepath;
    }
    public String getnowarninglightspicturepath() {
        return nowarninglightspicturepath;
    }
    public void setvehiclephotopicturepath(String vehiclephotopicturepath) {
        this.vehiclephotopicturepath = vehiclephotopicturepath;
    }
    public String getvehiclephotopicturepath() {
        return vehiclephotopicturepath;
    }

    public void setlocationlat(String locationlat) {
        this.locationlat = locationlat;
    }
    public String getlocationlat() {
        return locationlat;
    }

    public void setlocationlong(String locationlong) {
        this.locationlong = locationlong;
    }
    public String getlocationlong() {
        return locationlong;
    }






    //////////////////////////////////////////////////////////////////////////////////

    //--------------------------------------------------------------------------------------

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("user_name", user_name);
        result.put("user_email", user_email);
        result.put("user_company", user_company);
        result.put("user_contact_number", user_contact_number);
        result.put("name", name);
        result.put("email", email);
        result.put("report_email_recipient", report_email_recipient);
        result.put("Reg", Reg);
        result.put("location_address_view", location_address_view);
        result.put("in_cab_temp_fix", in_cab_temp_fix);
        result.put("in_cab_des_default", in_cab_des_default);
        result.put("endDate", endDate);
        result.put("startDate", startDate);
        result.put("winmirtempfixfill", winmirtempfixfill);
        result.put("winmirdescribedefectfill", winmirdescribedefectfill);
        result.put("seatbeltstempfixfill", seatbeltstempfixfill);
        result.put("seatbeltsdescribedefectfill", seatbeltsdescribedefectfill);
        result.put("washerandwipertempfixfill", washerandwipertempfixfill);
        result.put("washerandwiperdescribedefectfill", washerandwiperdescribedefectfill);
        result.put("horntempfixfill", horntempfixfill);
        result.put("horndescribedefectfill", horndescribedefectfill);
        result.put("breakwarninglighttempfixfill", breakwarninglighttempfixfill);
        result.put("breakwarninglightdescribedefectfill", breakwarninglightdescribedefectfill);
        result.put("gaugetempfixfill", gaugetempfixfill);
        result.put("gaugedescribedefectfill", gaugedescribedefectfill);
        result.put("tachotempfixfill", tachotempfixfill);
        result.put("tachodescribedefectfill", tachodescribedefectfill);
        result.put("airleakstempfixfill", airleakstempfixfill);
        result.put("airleaksdescribedefectfill", airleaksdescribedefectfill);
        //Driving Inspection
        result.put("steeringbreakingtempfixfill", steeringbreakingtempfixfill);
        result.put("steeringbreakingdescribedefectfill", steeringbreakingdescribedefectfill);
        result.put("loadsecuretempfixfill", loadsecuretempfixfill);
        result.put("loadsecuredescribedefectfill", loadsecuredescribedefectfill);
        result.put("tachospeedotempfixfill", tachospeedotempfixfill);
        result.put("tachospeedodescribedefectfill", tachospeedodescribedefectfill);
        result.put("nowarninglightstempfixfill", nowarninglightstempfixfill);
        result.put("nowarninglightsdescribedefectfill", nowarninglightsdescribedefectfill);
        //Outside Inspection
        result.put("taxinsurancetempfixfill", taxinsurancetempfixfill);
        result.put("taxinsurancedescribedefectfill", taxinsurancedescribedefectfill);
        result.put("wheelstyrestempfixfill", wheelstyrestempfixfill);
        result.put("wheelstyresdescribedefectfill", wheelstyresdescribedefectfill);
        result.put("lightsreflectorstempfixfill", lightsreflectorstempfixfill);
        result.put("lightsreflectorsdescribedefectfill", lightsreflectorsdescribedefectfill);
        result.put("exhausttempfixfill", exhausttempfixfill);
        result.put("exhaustdescribedefectfill", exhaustdescribedefectfill);
        result.put("sparetowtempfixfill", sparetowtempfixfill);
        result.put("sparetowdescribedefectfill", sparetowdescribedefectfill);
        result.put("trailerbraketempfixfill", trailerbraketempfixfill);
        result.put("trailerbrakedescribedefectfill", trailerbrakedescribedefectfill);
        result.put("bodyguardstempfixfill", bodyguardstempfixfill);
        result.put("bodyguardsdescribedefectfill", bodyguardsdescribedefectfill);
        result.put("landinglegtempfixfill", landinglegtempfixfill);
        result.put("landinglegdescribedefectfill", landinglegdescribedefectfill);
        result.put("regplatetempfixfill", regplatetempfixfill);
        result.put("regplatedescribedefectfill", regplatedescribedefectfill);
        result.put("fluidleakstempfixfill", fluidleakstempfixfill);
        result.put("fluidleaksdescribedefectfill", fluidleaksdescribedefectfill);
        result.put("airelectrialtempfixfill", airelectrialtempfixfill);
        result.put("airelectrialdescribedefectfill", airelectrialdescribedefectfill);
        result.put("airsuspensiontempfixfill", airsuspensiontempfixfill);
        result.put("airsuspensiondescribedefectfill", airsuspensiondescribedefectfill);
        //url addresses
        result.put("taxinsurancepictureuri", taxinsurancepictureuri);
        result.put("taxinsurancepicturepath", taxinsurancepicturepath);
        result.put("regplatepictureuri", regplatepictureuri);
        result.put("regplatepicturepath", regplatepicturepath);
        result.put("airelectrialpictureuri", airelectrialpictureuri);
        result.put("fluidleakspictureuri", fluidleakspictureuri);
        result.put("airsuspensionpictureuri", airsuspensionpictureuri);
        result.put("wheelsandtyrespictureuri", wheelsandtyrespictureuri);
        result.put("lightsreflectorspictureuri", lightsreflectorspictureuri);
        result.put("exhaustpictureuri", exhaustpictureuri);
        result.put("bodyguardspictureuri", bodyguardspictureuri);
        result.put("landinglegpictureuri", landinglegpictureuri);
        result.put("sparetowpictureuri", sparetowpictureuri);
        result.put("trailerbrakepictureuri", trailerbrakepictureuri);

        result.put("winmirpictureuri", winmirpictureuri);
        result.put("seatbeltspictureuri", seatbeltspictureuri);
        result.put("washerandwiperpictureuri", washerandwiperpictureuri);
        result.put("hornpictureuri", hornpictureuri);
        result.put("breakwarninglightpictureuri", breakwarninglightpictureuri);
        result.put("gaugepictureuri", gaugepictureuri);
        result.put("tachopictureuri", tachopictureuri);
        result.put("airleakspictureuri", airleakspictureuri);
        result.put("steeringbreakingpictureuri", steeringbreakingpictureuri);
        result.put("loadsecurepictureuri", loadsecurepictureuri);
        result.put("tachospeedopictureuri", tachospeedopictureuri);
        result.put("nowarninglightspictureuri", nowarninglightspictureuri);

        result.put("vehiclephotopictureuri", vehiclephotopictureuri);

        result.put("airelectrialpicturepath", airelectrialpicturepath);
        result.put("fluidleakspicturepath", fluidleakspicturepath);
        result.put("airsuspensionpicturepath", airsuspensionpicturepath);
        result.put("wheelsandtyrespicturepath", wheelsandtyrespicturepath);
        result.put("lightsreflectorspicturepath", lightsreflectorspicturepath);
        result.put("exhaustpicturepath", exhaustpicturepath);
        result.put("bodyguardspicturepath", bodyguardspicturepath);
        result.put("landinglegpicturepath", landinglegpicturepath);
        result.put("sparetowpicturepath", sparetowpicturepath);
        result.put("trailerbrakepicturepath", trailerbrakepicturepath);

        result.put("winmirpicturepath", winmirpicturepath);
        result.put("seatbeltspicturepath", seatbeltspicturepath);
        result.put("washerandwiperpicturepath", washerandwiperpicturepath);
        result.put("hornpicturepath", hornpicturepath);
        result.put("breakwarninglightpicturepath", breakwarninglightpicturepath);
        result.put("gaugepicturepath", gaugepicturepath);
        result.put("tachopicturepath", tachopicturepath);
        result.put("airleakspicturepath", airleakspicturepath);
        result.put("steeringbreakingpicturepath", steeringbreakingpicturepath);
        result.put("loadsecurepicturepath", loadsecurepicturepath);
        result.put("tachospeedopicturepath", tachospeedopicturepath);
        result.put("nowarninglightspicturepath", nowarninglightspicturepath);

        result.put("vehiclephotopicturepath", vehiclephotopicturepath);

        result.put("locationlat", locationlat);
        result.put("locationlong", locationlong);

        return result;
    }
}