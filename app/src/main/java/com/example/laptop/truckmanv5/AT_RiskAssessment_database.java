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
        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT RiskAssessment Form").addChildEventListener(childEventListener);
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

        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT RiskAssessment Form").child(currentInspectionDate).updateChildren(postValues);
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

        ///////////////////////////////////////Risk Assessment/////////////////////////////////////////////////

        add.setraform_trafficppe_yes(model.getraform_trafficppe_yes());
        add.setraform_trafficppe_no(model.getraform_trafficppe_no());
        add.setraform_trafficroads(model.getraform_trafficroads());
        add.setraform_trafficfootpath(model.getraform_trafficfootpath());
        add.setraform_traffictmpguidelines_yes(model.getraform_traffictmpguidelines_yes());
        add.setraform_traffictmpguidelines_no(model.getraform_traffictmpguidelines_no());
        add.setraform_trafficbeacon_yes(model.getraform_trafficbeacon_yes());
        add.setraform_trafficbeacon_no(model.getraform_trafficbeacon_no());
        add.setraform_trafficleftsite_yes(model.getraform_trafficleftsite_yes());
        add.setraform_trafficleftsite_no(model.getraform_trafficleftsite_no());
        add.setraform_trafficfallsystem_yes(model.getraform_trafficfallsystem_yes());
        add.setraform_trafficfallsystem_no(model.getraform_trafficfallsystem_no());
        ///////////////////////////////////////Risk Assessment/////////////////////////////////////////////////


        add.setat0013_3ck_tony_robinson(model.getat0013_3ck_tony_robinson());
        add.setat0013_3ck_mark_dixon(model.getat0013_3ck_mark_dixon());
        add.setat0013_3ck_brian_byrne(model.getat0013_3ck_brian_byrne());
        add.setat0013_3ck_declan_byrne(model.getat0013_3ck_declan_byrne());
        add.setat0013_3ck_michael_mccormack(model.getat0013_3ck_michael_mccormack());
        add.setat0013_3ck_david_mcasey(model.getat0013_3ck_david_mcasey());
        add.setat0013_3ck_eamonn_storey(model.getat0013_3ck_eamonn_storey());
        add.setat0013_3ck_thomas_martin(model.getat0013_3ck_thomas_martin());
        add.setat0013_3ck_richard_gilligan(model.getat0013_3ck_richard_gilligan());
        add.setat0013_3ck_noel_perry(model.getat0013_3ck_noel_perry());
        add.setat0013_3ck_willie_harris(model.getat0013_3ck_willie_harris());
        add.setat0013_3ck_kieran_fitzgerald(model.getat0013_3ck_kieran_fitzgerald());
        add.setat0013_3ck_mark_dalton(model.getat0013_3ck_mark_dalton());
        add.setat0013_3ck_william_burke(model.getat0013_3ck_william_burke());
        add.setat0013_3ck_martin_maher(model.getat0013_3ck_martin_maher());
        add.setat0013_3ck_graham_mcloghlin(model.getat0013_3ck_graham_mcloghlin());
        add.setat0013_3ck_christy_oreilly(model.getat0013_3ck_christy_oreilly());
        add.setat0013_3ck_ritchie_kavanagh(model.getat0013_3ck_ritchie_kavanagh());
        add.setat0013_3ck_river_cleaning(model.getat0013_3ck_river_cleaning());
        add.setat0013_3ck_debris_removal(model.getat0013_3ck_debris_removal());
        add.setat0013_3ck_screen_cleaning(model.getat0013_3ck_screen_cleaning());
        add.setat0013_3ck_tree_cutting(model.getat0013_3ck_tree_cutting());
        add.setat0013_3ck_weir_maintenance(model.getat0013_3ck_weir_maintenance());
        add.setat0013_3ck_river_dredging(model.getat0013_3ck_river_dredging());
        add.setat0013_3ck_nature_works_other(model.getat0013_3ck_nature_works_other());
        add.setat0013_3ck_nature_works_other_description(model.getat0013_3ck_nature_works_other_description());

        add.setat0013_3ck_safepass(model.getat0013_3ck_safepass());
        add.setat0013_3ck_manual_handling(model.getat0013_3ck_manual_handling());
        add.setat0013_3ck_water_awareness(model.getat0013_3ck_water_awareness());
        add.setat0013_3ck_chainsaw(model.getat0013_3ck_chainsaw());
        add.setat0013_3ck_tirfor_winch(model.getat0013_3ck_tirfor_winch());
        add.setat0013_3ck_confined_space(model.getat0013_3ck_confined_space());
        add.setat0013_3ck_safety_footware(model.getat0013_3ck_safety_footware());
        add.setat0013_3ck_high_vis_vest(model.getat0013_3ck_high_vis_vest());
        add.setat0013_3ck_gloves(model.getat0013_3ck_gloves());
        add.setat0013_3ck_safety_helmet(model.getat0013_3ck_safety_helmet());
        add.setat0013_3ck_ear_protection(model.getat0013_3ck_ear_protection());
        add.setat0013_3ck_eye_protection(model.getat0013_3ck_eye_protection());
        add.setat0013_3ck_life_jacket(model.getat0013_3ck_life_jacket());
        add.setat0013_3ck_chainsaw_suit(model.getat0013_3ck_chainsaw_suit());
        add.setat0013_3ck_waders(model.getat0013_3ck_waders());
        add.setat0013_3ck_throw_bags(model.getat0013_3ck_throw_bags());
        add.setat0013_3ck_life_line(model.getat0013_3ck_life_line());
        add.setat0013_3ck_hazard_life_jacket(model.getat0013_3ck_hazard_life_jacket());
        add.setat0013_3ck_hazard_throw_bags(model.getat0013_3ck_hazard_throw_bags());
        add.setat0013_3ck_hazard_na(model.getat0013_3ck_hazard_na());
        add.setat0013_3ck_river_bank_life_line(model.getat0013_3ck_river_bank_life_line());
        add.setat0013_3ck_river_bank_laddders(model.getat0013_3ck_river_bank_laddders());
        add.setat0013_3ck_river_bank_safety_footware(model.getat0013_3ck_river_bank_safety_footware());
        add.setat0013_3ck_river_bank_na(model.getat0013_3ck_river_bank_na());
        add.setat0013_3ck_hazard_yes(model.getat0013_3ck_hazard_yes());
        add.setat0013_3ck_hazard_no(model.getat0013_3ck_hazard_no());
        add.setat0013_3ck_barrier_na(model.getat0013_3ck_barrier_na());
        add.setat0013_3ck_hazard_hog_avoid(model.getat0013_3ck_hazard_hog_avoid());
        add.setat0013_3ck_hazard_hog_ppe(model.getat0013_3ck_hazard_hog_ppe());
        add.setat0013_3ck_hazard_hog_na(model.getat0013_3ck_hazard_hog_na());
        add.setat0013_3ck_hazard_hygine_ppe(model.getat0013_3ck_hazard_hygine_ppe());
        add.setat0013_3ck_hazard_washing_facilities(model.getat0013_3ck_hazard_washing_facilities());
        add.setat0013_3ck_hazard_canteen(model.getat0013_3ck_hazard_canteen());
        add.setat0013_3ck_hazard_clean_tools(model.getat0013_3ck_hazard_clean_tools());
        add.setat0013_3ck_hazard_sharp_prevention_pack(model.getat0013_3ck_hazard_sharp_prevention_pack());
        add.setat0013_3ck_hazard_hygiene_na(model.getat0013_3ck_hazard_hygiene_na());
        add.setat0013_3ck_hazard_tmp_number(model.getat0013_3ck_hazard_tmp_number());
        add.setat0013_3ck_hazard_tmp_na(model.getat0013_3ck_hazard_tmp_na());
        add.setat0013_3ck_hazard_tmp_comments(model.getat0013_3ck_hazard_tmp_comments());

        add.setat0013_3pictureuri(model.getat0013_3pictureuri());
        add.setat0013_3picturepath(model.getat0013_3picturepath());

        Date date = new Date();
        String dateString = DateFormat.getDateTimeInstance().format(date);
        add.setendDate(dateString);

        add.setstartDate(currentInspectionDate);
        Map<String, Object> postValues = add.toMap();

        // Add a date field to the person class, set the date as this dateString

        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT RiskAssessment Form").child(currentInspectionDate).updateChildren(postValues);
    }

    public void deletePerson(int position) {
        String clickedKey = keysArray.get(position);

        AT_RiskAssessment_model p = arrayListAT_RiskAssessment.get(position);

        String at0013_3picturepath = p.getat0013_3picturepath();


        if (at0013_3picturepath != null) {

            mStorage.child(at0013_3picturepath).delete();
            String folderPath = p.getat0013_3picturepath().substring(0, p.getat0013_3picturepath().lastIndexOf('/'));
            mStorage.child(folderPath).delete();
        }
        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT RiskAssessment Form").child(clickedKey).removeValue();
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
                return true;

            case R.id.vrdatabase:
                startActivity (new Intent(this, dccdrainageforms.class));
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

}