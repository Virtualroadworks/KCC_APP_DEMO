package com.example.laptop.truckmanv5;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
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

public class AT_RiskAssessment_database extends AppCompatActivity {

    static final String TAG = "AT_RiskAssessment_DB";
    private DatabaseReference mDatabase;
    private FloatingActionButton fab;
    private ProgressBar progressBar;
    private ListView lvPerson;
    private static AT_RiskAssessment_database AT_RiskAssessment_database;
    private static ArrayList<AT_RiskAssessment_model> arrayListAT_RiskAssessment = new ArrayList<>();
    private AT_RiskAssessment_listadaptor AT_RiskAssessment_listadaptor;
    private ArrayList<String> keysArray;
    private FirebaseAuth firebaseAuth;
    private String currentInspectionDate = "";
    private StorageReference mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at__risk_assessment_database);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Risk Assessment Form").addChildEventListener(childEventListener);
        AT_RiskAssessment_database = this;

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        lvPerson = (ListView) findViewById(R.id.PersonList);

        keysArray = new ArrayList<>();

        mStorage = FirebaseStorage.getInstance().getReference();

        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AT_RiskAssessment_database.this, AT_RiskAssessment_formfilled.class);
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

        arrayListAT_RiskAssessment.clear();
        AT_RiskAssessment_listadaptor = new AT_RiskAssessment_listadaptor (AT_RiskAssessment_database.this, arrayListAT_RiskAssessment);
        lvPerson.setAdapter(AT_RiskAssessment_listadaptor);

        Intent view= getIntent();
        new AT_RiskAssessment_database.Wait().execute();

        if (view.hasExtra("CalledFromdccnorthsideforms") == true) {

            boolean isFromDaily_forms = view.getExtras().getBoolean("CalledFromdccnorthsideforms");
            if (isFromDaily_forms == true) {
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
            return(arrayListAT_RiskAssessment.size()==0);
        }

        @Override
        protected void onPostExecute(Boolean bool) {
            if(bool)
                updateView();
        }
    }

    public void startInspection() {

        Intent intent = new Intent(AT_RiskAssessment_database.this, AT_RiskAssessment_view.class);


        Date date = new Date();
        currentInspectionDate = DateFormat.getDateTimeInstance().format(date);

        // Add a date field to the person class, set the date as this dateString

        AT_RiskAssessment_model AT_RiskAssessment_model = new AT_RiskAssessment_model();
        Map<String, Object> postValues = AT_RiskAssessment_model.toMap();

        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Risk Assessment Form").child(currentInspectionDate).updateChildren(postValues);
        intent.putExtra("Date", currentInspectionDate);
        intent.putExtra("Position", -1);
        startActivity(intent);
    }

    public static AT_RiskAssessment_database getInstance() {
        return AT_RiskAssessment_database;
    }

    public ArrayList<String> getKeysArray() {
        return keysArray;
    }

    public DatabaseReference getmDatabase() {
        return mDatabase;
    }


    public void addAT_RiskAssessment_model(AT_RiskAssessment_model model) {
        AT_RiskAssessment_model add = new AT_RiskAssessment_model();
        add.setuser_name(model.getuser_name());
        add.setuser_email(model.getuser_email());
        add.setuser_department_area(model.getuser_department_area());
        add.setuser_contact_number(model.getuser_contact_number());
        add.setstartDate(model.getstartDate());
        add.setendDate(model.getendDate());


        ///////////////////////////////////////1 Traffic/////////////////////////////////////////////////

        add.settraffic_ppe(model.gettraffic_ppe());
        add.settraffic_roads_or_footpath(model.gettraffic_roads_or_footpath());
        add.settraffic_following_guidelines(model.gettraffic_following_guidelines());
        add.settraffic_beacons(model.gettraffic_beacons());
        add.settraffic_left_site_in_good_order(model.gettraffic_left_site_in_good_order());

        ///////////////////////////////////////2 Heights/////////////////////////////////////////////////

        add.setheights_fall_arrest_system(model.getheights_fall_arrest_system());
        add.setheights_harness_inspection(model.getheights_harness_inspection());
        add.setheights_ladder_inspection(model.getheights_ladder_inspection());
        add.setheights_laddertied(model.getheights_laddertied());
        add.setheights_manholebarrier(model.getheights_manholebarrier());

        ///////////////////////////////////////3 River Cleaning/////////////////////////////////////////////////

        add.setriverlifejacket(model.getriverlifejacket());
        add.setriverwaders(model.getriverwaders());
        add.setrivertieoffpoint(model.getrivertieoffpoint());
        add.setriversafeaccess(model.getriversafeaccess());

        ///////////////////////////////////////4 Overhead Powerlines/////////////////////////////////////////////////

        add.setoverheadpowerlines(model.getoverheadpowerlines());

        ///////////////////////////////////////5 underground Services/////////////////////////////////////////////////

        add.setundergrounddrawings(model.getundergrounddrawings());
        add.setundergroundcat(model.getundergroundcat());

        ///////////////////////////////////////6 Manual Handling/////////////////////////////////////////////////

        add.setmanhandleloadassessed(model.getmanhandleloadassessed());
        add.setmanhandlemechanical(model.getmanhandlemechanical());
        add.setmanhandletwomanlift(model.getmanhandletwomanlift());

        ///////////////////////////////////////7 Confined Space/////////////////////////////////////////////////

        add.setconfinedspace(model.getconfinedspace());

        ///////////////////////////////////////8 Power Tools/////////////////////////////////////////////////

        add.setpowertools(model.getpowertools());

        ///////////////////////////////////////9 General PPE/////////////////////////////////////////////////

        add.setgeneralppesafetygoogles(model.getgeneralppesafetygoogles());
        add.setgeneralppehearing(model.getgeneralppehearing());
        add.setgeneralppegloves(model.getgeneralppegloves());
        add.setgeneralppedustoverall(model.getgeneralppedustoverall());
        add.setgeneralppehivis(model.getgeneralppehivis());
        add.setgeneralppehardhat(model.getgeneralppehardhat());
        add.setgeneralppedustmask(model.getgeneralppedustmask());

        add.setlocationlat(model.getlocationlat());
        add.setlocationlong(model.getlocationlong());


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Date date = new Date();
        String dateString = DateFormat.getDateTimeInstance().format(date);
        add.setendDate(dateString);

        add.setstartDate(currentInspectionDate);
        Map<String, Object> postValues = add.toMap();

        // Add a date field to the person class, set the date as this dateString

        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Risk Assessment Form").child(currentInspectionDate).updateChildren(postValues);
    }

    public void deletePerson(int position) {
        String clickedKey = keysArray.get(position);

        AT_RiskAssessment_model p = arrayListAT_RiskAssessment.get(position);


        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Risk Assessment Form").child(clickedKey).removeValue();
    }



    ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            lvPerson.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            Log.d(TAG, dataSnapshot.getKey() + ":" + dataSnapshot.getValue().toString());
            AT_RiskAssessment_model person = dataSnapshot.getValue(AT_RiskAssessment_model.class);

            arrayListAT_RiskAssessment.add(person);
            keysArray.add(dataSnapshot.getKey());
            updateView();
        }
        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            String changedKey = dataSnapshot.getKey();
            int changedIndex = keysArray.indexOf(changedKey);
            AT_RiskAssessment_model person = dataSnapshot.getValue(AT_RiskAssessment_model.class);
            arrayListAT_RiskAssessment.set(changedIndex,person);
            updateView();
        }
        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {
            String deletedKey = dataSnapshot.getKey();
            int removedIndex = keysArray.indexOf(deletedKey);
            keysArray.remove(removedIndex);
            arrayListAT_RiskAssessment.remove(removedIndex);
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
        arrayListAT_RiskAssessment.clear();
        mDatabase.removeEventListener(childEventListener);
    }

    public void updateView() {
        AT_RiskAssessment_listadaptor.notifyDataSetChanged();
        lvPerson.invalidate();
        progressBar.setVisibility(View.GONE);
        lvPerson.setVisibility(View.VISIBLE);
    }
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
                finish();

            case R.id.vrdatabase:
                startActivity (new Intent(this, dccdrainageforms.class));
                finish();

        }

        return super.onOptionsItemSelected(item);
    }

}