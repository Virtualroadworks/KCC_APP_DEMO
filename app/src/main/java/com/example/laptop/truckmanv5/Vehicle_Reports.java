package com.example.laptop.truckmanv5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Vehicle_Reports extends AppCompatActivity  {

    static final String TAG = "Vehicle_Reports";
    private DatabaseReference mDatabase;
    private FloatingActionButton fab;
    private ProgressBar progressBar;
    private ListView lvPerson;
    private static Vehicle_Reports Vehicle_Reports;
    private static ArrayList<Person> arrayListPerson = new ArrayList<>();
    private PersonDetailsAdapter PersonDetailsAdapter;
    private ArrayList<String> keysArray;
    private FirebaseAuth firebaseAuth;
    private String currentInspectionDate = "";
    private StorageReference mStorage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle__reports);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("inspections").addChildEventListener(childEventListener);
        Vehicle_Reports = this;

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        lvPerson = (ListView) findViewById(R.id.PersonList);

        keysArray = new ArrayList<>();

        mStorage = FirebaseStorage.getInstance().getReference();


        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Vehicle_Reports.this, Person_Details.class);
                intent.putExtra("Position", position);
                startActivity(intent);
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            startInspection();
            }
        });



        arrayListPerson.clear();
        PersonDetailsAdapter = new PersonDetailsAdapter(Vehicle_Reports.this, arrayListPerson);
        lvPerson.setAdapter(PersonDetailsAdapter);


        ///Skipping Vehicle reports and and Autoclicking Fab Button.
        Intent view= getIntent();
        new Wait().execute();

        if (view.hasExtra("CalledFromMainView") == true) {

            boolean isFromMainView = view.getExtras().getBoolean("CalledFromMainView");

            if (isFromMainView == true) {

                startInspection();
            }
        }


    }
    private class Wait extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            lvPerson.setVisibility(View.GONE);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie) {
                Log.d(TAG,ie.toString());
            }
            return(arrayListPerson.size()==0);
        }

        @Override
        protected void onPostExecute(Boolean bool) {
            if(bool)
                updateView();
        }
    }

    public void startInspection() {

        Intent intent = new Intent(Vehicle_Reports.this, Add_or_Update_Inspection.class);


        Date date = new Date();
        currentInspectionDate = DateFormat.getDateTimeInstance().format(date);

        // Add a date field to the person class, set the date as this dateString

        Person person = new Person();
        Map<String, Object> postValues = person.toMap();



        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("inspections").child(currentInspectionDate).updateChildren(postValues);
        intent.putExtra("Date", currentInspectionDate);
        intent.putExtra("Position", -1);
        startActivity(intent);
    }


    public static Vehicle_Reports getInstance() {
        return Vehicle_Reports;
    }

    public ArrayList<String> getKeysArray() {
        return keysArray;
    }

    public DatabaseReference getmDatabase() {
        return mDatabase;
    }


    public void addPerson(Person model) {
        Person person = new Person();
        person.setuser_name(model.getuser_name());
        person.setuser_email(model.getuser_email());
        person.setuser_contact_number(model.getuser_contact_number());
        person.setuser_company(model.getuser_company());
        person.setreport_email_recipient(model.getreport_email_recipient());
        person.setReg(model.getReg());
        person.setlocation_address_view(model.getlocation_address_view());
        person.setin_cab_temp_fix(model.getin_cab_temp_fix());
        person.setin_cab_des_default(model.getin_cab_des_default());
        /////////////////////////////////////////////////////////////
        person.setwinmirtempfixfill(model.getwinmirtempfixfill());
        person.setwinmirdescribedefectfill(model.getwinmirdescribedefectfill());
        person.setseatbeltstempfixfill(model.getseatbeltstempfixfill());
        person.setseatbeltsdescribedefectfill(model.getseatbeltsdescribedefectfill());
        person.setwasherandwipertempfixfill(model.getwasherandwipertempfixfill());
        person.setwasherandwiperdescribedefectfill(model.getwasherandwiperdescribedefectfill());
        person.sethorntempfixfill(model.gethorntempfixfill());
        person.sethorndescribedefectfill(model.gethorndescribedefectfill());
        person.setbreakwarninglighttempfixfill(model.getbreakwarninglighttempfixfill());
        person.setbreakwarninglightdescribedefectfill(model.getbreakwarninglightdescribedefectfill());
        person.setgaugetempfixfill(model.getgaugetempfixfill());
        person.setgaugedescribedefectfill(model.getgaugedescribedefectfill());
        person.settachotempfixfill(model.gettachotempfixfill());
        person.settachodescribedefectfill(model.gettachodescribedefectfill());
        person.setairleakstempfixfill(model.getairleakstempfixfill());
        person.setairleaksdescribedefectfill(model.getairleaksdescribedefectfill());
        //Driving Inspection
        person.setsteeringbreakingtempfixfill(model.getsteeringbreakingtempfixfill());
        person.setsteeringbreakingdescribedefectfill(model.getsteeringbreakingdescribedefectfill());
        person.setloadsecuretempfixfill(model.getloadsecuretempfixfill());
        person.setloadsecuredescribedefectfill(model.getloadsecuredescribedefectfill());
        person.settachospeedotempfixfill(model.gettachospeedotempfixfill());
        person.settachospeedodescribedefectfill(model.gettachospeedodescribedefectfill());
        person.setnowarninglightstempfixfill(model.getnowarninglightstempfixfill());
        person.setnowarninglightsdescribedefectfill(model.getnowarninglightsdescribedefectfill());
        //Outside Inspection
        person.settaxinsurancetempfixfill(model.gettaxinsurancetempfixfill());
        person.settaxinsurancedescribedefectfill(model.gettaxinsurancedescribedefectfill());
        person.setwheelstyrestempfixfill(model.getwheelstyrestempfixfill());
        person.setwheelstyresdescribedefectfill(model.getwheelstyresdescribedefectfill());
        person.setlightsreflectorstempfixfill(model.getlightsreflectorstempfixfill());
        person.setlightsreflectorsdescribedefectfill(model.getlightsreflectorsdescribedefectfill());
        person.setexhausttempfixfill(model.getexhausttempfixfill());
        person.setexhaustdescribedefectfill(model.getexhaustdescribedefectfill());
        person.setsparetowtempfixfill(model.getsparetowtempfixfill());
        person.setsparetowdescribedefectfill(model.getsparetowdescribedefectfill());
        person.settrailerbraketempfixfill(model.gettrailerbraketempfixfill());
        person.settrailerbrakedescribedefectfill(model.gettrailerbrakedescribedefectfill());
        person.setbodyguardstempfixfill(model.getbodyguardstempfixfill());
        person.setbodyguardsdescribedefectfill(model.getbodyguardsdescribedefectfill());
        person.setlandinglegtempfixfill(model.getlandinglegtempfixfill());
        person.setlandinglegdescribedefectfill(model.getlandinglegdescribedefectfill());
        person.setregplatetempfixfill(model.getregplatetempfixfill());
        person.setregplatedescribedefectfill(model.getregplatedescribedefectfill());
        person.setfluidleakstempfixfill(model.getfluidleakstempfixfill());
        person.setfluidleaksdescribedefectfill(model.getfluidleaksdescribedefectfill());
        person.setairelectrialtempfixfill(model.getairelectrialtempfixfill());
        person.setairelectrialdescribedefectfill(model.getairelectrialdescribedefectfill());
        person.setairsuspensiontempfixfill(model.getairsuspensiontempfixfill());
        person.setairsuspensiondescribedefectfill(model.getairsuspensiondescribedefectfill());
        //url addresses
        person.settaxinsurancepictureuri(model.gettaxinsurancepictureuri());
        person.settaxinsurancepicturepath(model.gettaxinsurancepicturepath());
        person.setregplatepictureuri(model.getregplatepictureuri());
        person.setregplatepicturepath(model.getregplatepicturepath());
        person.setairelectrialpictureuri(model.getairelectrialpictureuri());
        person.setfluidleakspictureuri(model.getfluidleakspictureuri());
        person.setairsuspensionpictureuri(model.getairsuspensionpictureuri());
        person.setwheelsandtyrespictureuri(model.getwheelsandtyrespictureuri());
        person.setlightsreflectorspictureuri(model.getlightsreflectorspictureuri());
        person.setexhaustpictureuri(model.getexhaustpictureuri());
        person.setbodyguardspictureuri(model.getbodyguardspictureuri());
        person.setlandinglegpictureuri(model.getlandinglegpictureuri());
        person.setsparetowpictureuri(model.getsparetowpictureuri());
        person.settrailerbrakepictureuri(model.gettrailerbrakepictureuri());

        person.setwinmirpictureuri(model.getwinmirpictureuri());
        person.setseatbeltspictureuri(model.getseatbeltspictureuri());
        person.setwasherandwiperpictureuri(model.getwasherandwiperpictureuri());
        person.sethornpictureuri(model.gethornpictureuri());
        person.setbreakwarninglightpictureuri(model.getbreakwarninglightpictureuri());
        person.setgaugepictureuri(model.getgaugepictureuri());
        person.settachopictureuri(model.gettachopictureuri());
        person.setairleakspictureuri(model.getairleakspictureuri());

        person.setsteeringbreakingpictureuri(model.getsteeringbreakingpictureuri());
        person.setloadsecurepictureuri(model.getloadsecurepictureuri());
        person.settachospeedopictureuri(model.gettachospeedopictureuri());
        person.setnowarninglightspictureuri(model.getnowarninglightspictureuri());

        person.setvehiclephotopictureuri(model.getvehiclephotopictureuri());

        person.setairelectrialpicturepath(model.getairelectrialpicturepath());
        person.setfluidleakspicturepath(model.getfluidleakspicturepath());
        person.setairsuspensionpicturepath(model.getairsuspensionpicturepath());
        person.setwheelsandtyrespicturepath(model.getwheelsandtyrespicturepath());
        person.setlightsreflectorspicturepath(model.getlightsreflectorspicturepath());
        person.setexhaustpicturepath(model.getexhaustpicturepath());
        person.setbodyguardspicturepath(model.getbodyguardspicturepath());
        person.setlandinglegpicturepath(model.getlandinglegpicturepath());
        person.setsparetowpicturepath(model.getsparetowpicturepath());
        person.settrailerbrakepicturepath(model.gettrailerbrakepicturepath());

        person.setwinmirpicturepath(model.getwinmirpicturepath());
        person.setseatbeltspicturepath(model.getseatbeltspicturepath());
        person.setwasherandwiperpicturepath(model.getwasherandwiperpicturepath());
        person.sethornpicturepath(model.gethornpicturepath());
        person.setbreakwarninglightpicturepath(model.getbreakwarninglightpicturepath());
        person.setgaugepicturepath(model.getgaugepicturepath());
        person.settachopicturepath(model.gettachopicturepath());
        person.setairleakspicturepath(model.getairleakspicturepath());

        person.setsteeringbreakingpicturepath(model.getsteeringbreakingpicturepath());
        person.setloadsecurepicturepath(model.getloadsecurepicturepath());
        person.settachospeedopicturepath(model.gettachospeedopicturepath());
        person.setnowarninglightspicturepath(model.getnowarninglightspicturepath());

        person.setvehiclephotopicturepath(model.getvehiclephotopicturepath());

        Date date = new Date();
        String dateString = DateFormat.getDateTimeInstance().format(date);
        person.setendDate(dateString);

        person.setstartDate(currentInspectionDate);
        Map<String, Object> postValues = person.toMap();

        // Add a date field to the person class, set the date as this dateString

        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("LastReportdone").updateChildren(postValues);


        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("inspections").child(currentInspectionDate).updateChildren(postValues);
    }

    public void deletePerson(int position) {
        String clickedKey = keysArray.get(position);


        Person p = arrayListPerson.get(position);

       /* String taxinsurancepicturePath = p.gettaxinsurancepicturepath();
        String regplatepicturePath = p.getregplatepicturepath();
        String airelectrialpicturePath = p.getairelectrialpicturepath();
        String fluidleakspicturePath = p.getfluidleakspicturepath();
        String wheelsandtyrespicturePath = p.getwheelsandtyrespicturepath();
        String lightsreflectorspicturePath = p.getlightsreflectorspicturepath();
        String exhaustpicturePath = p.getexhaustpicturepath();
        String bodyguardspicturePath = p.getbodyguardspicturepath();
        String landinglegpicturePath = p.getlandinglegpicturepath();
        String sparetowpicturePath = p.getsparetowpicturepath();
        String winmirpicturePath = p.getwinmirpicturepath();
        String seatbeltspicturePath = p.getseatbeltspicturepath();
        String washerandwiperpicturePath = p.getwasherandwiperpicturepath();
        String hornpicturePath = p.gethornpicturepath();
        String breakwarninglightPath = p.getbreakwarninglightpicturepath();
        String gaugepicturePath = p.getgaugepicturepath();
        String tachopicturePath = p.gettachopicturepath();
        String airleakspicturePath= p.getairleakspicturepath();
        String steeringbreakingpicturePath = p.getsteeringbreakingpicturepath();
        String loadsecurepicturePath = p.getloadsecurepicturepath();
        String tachospeedopicturePath = p.gettachospeedopicturepath();
        String nowarninglightspicturePath = p.getnowarninglightspicturepath();
        String vehiclephotopicturePath = p.getvehiclephotopicturepath();

        if (taxinsurancepicturePath != null) {

            mStorage.child(taxinsurancepicturePath).delete();
            String folderPath = p.gettaxinsurancepicturepath().substring(0, p.gettaxinsurancepicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (regplatepicturePath != null) {

            mStorage.child(regplatepicturePath).delete();
            String folderPath = p.getregplatepicturepath().substring(0, p.getregplatepicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (fluidleakspicturePath != null) {

            mStorage.child(fluidleakspicturePath).delete();
            String folderPath = p.getfluidleakspicturepath().substring(0, p.getfluidleakspicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (airelectrialpicturePath != null) {

            mStorage.child(airelectrialpicturePath).delete();
            String folderPath = p.getairelectrialpicturepath().substring(0, p.getairelectrialpicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (wheelsandtyrespicturePath != null) {

            mStorage.child(wheelsandtyrespicturePath).delete();
            String folderPath = p.getwheelsandtyrespicturepath().substring(0, p.getwheelsandtyrespicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (lightsreflectorspicturePath != null) {

            mStorage.child(lightsreflectorspicturePath).delete();
            String folderPath = p.getlightsreflectorspicturepath().substring(0, p.getlightsreflectorspicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (exhaustpicturePath != null) {

            mStorage.child(exhaustpicturePath).delete();
            String folderPath = p.getexhaustpicturepath().substring(0, p.getexhaustpicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (bodyguardspicturePath != null) {

            mStorage.child(bodyguardspicturePath).delete();
            String folderPath = p.getbodyguardspicturepath().substring(0, p.getbodyguardspicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (landinglegpicturePath != null) {

            mStorage.child(landinglegpicturePath).delete();
            String folderPath = p.getlandinglegpicturepath().substring(0, p.getlandinglegpicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (sparetowpicturePath != null) {

            mStorage.child(sparetowpicturePath).delete();
            String folderPath = p.getsparetowpicturepath().substring(0, p.getsparetowpicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (winmirpicturePath != null) {

            mStorage.child(winmirpicturePath).delete();
            String folderPath = p.getwinmirpicturepath().substring(0, p.getwinmirpicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (seatbeltspicturePath != null) {

            mStorage.child(seatbeltspicturePath).delete();
            String folderPath = p.getseatbeltspicturepath().substring(0, p.getseatbeltspicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (washerandwiperpicturePath != null) {

            mStorage.child(washerandwiperpicturePath).delete();
            String folderPath = p.getwasherandwiperpicturepath().substring(0, p.getwasherandwiperpicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (hornpicturePath != null) {

            mStorage.child(hornpicturePath).delete();
            String folderPath = p.gethornpicturepath().substring(0, p.gethornpicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (breakwarninglightPath != null) {

            mStorage.child(breakwarninglightPath).delete();
            String folderPath = p.getbreakwarninglightpicturepath().substring(0, p.getbreakwarninglightpicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (gaugepicturePath != null) {

            mStorage.child(gaugepicturePath).delete();
            String folderPath = p.getgaugepicturepath().substring(0, p.getgaugepicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (tachopicturePath != null) {

            mStorage.child(tachopicturePath).delete();
            String folderPath = p.gettachopicturepath().substring(0, p.gettachopicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (airleakspicturePath != null) {

            mStorage.child(airleakspicturePath).delete();
            String folderPath = p.getairleakspicturepath().substring(0, p.getairleakspicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (steeringbreakingpicturePath != null) {

            mStorage.child(steeringbreakingpicturePath).delete();
            String folderPath = p.getsteeringbreakingpicturepath().substring(0, p.getsteeringbreakingpicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (loadsecurepicturePath != null) {

            mStorage.child(loadsecurepicturePath).delete();
            String folderPath = p.getloadsecurepicturepath().substring(0, p.getloadsecurepicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (tachospeedopicturePath != null) {

            mStorage.child(tachospeedopicturePath).delete();
            String folderPath = p.gettachospeedopicturepath().substring(0, p.gettachospeedopicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (nowarninglightspicturePath != null) {

            mStorage.child(nowarninglightspicturePath).delete();
            String folderPath = p.getnowarninglightspicturepath().substring(0, p.getnowarninglightspicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        if (vehiclephotopicturePath != null) {

            mStorage.child(vehiclephotopicturePath).delete();
            String folderPath = p.getvehiclephotopicturepath().substring(0, p.getvehiclephotopicturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }*/

        mStorage.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Photos").child(clickedKey).delete();
        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("inspections").child(clickedKey).removeValue();

    }


    ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            lvPerson.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            Log.d(TAG, dataSnapshot.getKey() + ":" + dataSnapshot.getValue().toString());
            Person person = dataSnapshot.getValue(Person.class);

            arrayListPerson.add(person);
            keysArray.add(dataSnapshot.getKey());
            updateView();
        }
        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            String changedKey = dataSnapshot.getKey();
            int changedIndex = keysArray.indexOf(changedKey);
            Person person = dataSnapshot.getValue(Person.class);
            arrayListPerson.set(changedIndex,person);
            updateView();
        }
        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {
            String deletedKey = dataSnapshot.getKey();
            int removedIndex = keysArray.indexOf(deletedKey);
            keysArray.remove(removedIndex);
            arrayListPerson.remove(removedIndex);
            updateView();
        }
        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
        @Override
        public void onCancelled(DatabaseError databaseError) {
            Toast.makeText(getApplicationContext(),"Could not update.",Toast.LENGTH_SHORT).show();
            updateView();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        arrayListPerson.clear();
        mDatabase.removeEventListener(childEventListener);
    }

    public void updateView() {
        PersonDetailsAdapter.notifyDataSetChanged();
        lvPerson.invalidate();
        progressBar.setVisibility(View.GONE);
        lvPerson.setVisibility(View.VISIBLE);
    }
    //////////////////Tool Bar Nav Buttons/////////////////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.vrhome:
                startActivity (new Intent(this, MainActivity.class));
                return true;



            case R.id.vrdatabase:
                startActivity (new Intent(this, Vehicle_Reports.class));
                return true;


        }

        return super.onOptionsItemSelected(item);
    }
}