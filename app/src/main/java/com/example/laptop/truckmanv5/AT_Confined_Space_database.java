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

public class AT_Confined_Space_database extends AppCompatActivity {

    static final String TAG = "AT_Confined_Space_DB";
    private DatabaseReference mDatabase;
    private FloatingActionButton fab;
    private ProgressBar progressBar;
    private ListView lvPerson;
    private static AT_Confined_Space_database AT_Confined_Space_database;
    private static ArrayList<AT_Confined_Space_model> arrayListAT_Confined_Space = new ArrayList<>();
    private AT_Confined_Space_listadaptor AT_Confined_Space_listadaptor;
    private ArrayList<String> keysArray;
    private FirebaseAuth firebaseAuth;
    private String currentInspectionDate = "";
    private StorageReference mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at__confined__space_database);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firebaseAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Confined Space Form").addChildEventListener(childEventListener);
        AT_Confined_Space_database = this;

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        lvPerson = (ListView) findViewById(R.id.PersonList);

        keysArray = new ArrayList<>();

        mStorage = FirebaseStorage.getInstance().getReference();

        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AT_Confined_Space_database.this, AT_Confined_Space_formfilled.class);
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

        arrayListAT_Confined_Space.clear();
        AT_Confined_Space_listadaptor = new AT_Confined_Space_listadaptor (AT_Confined_Space_database.this, arrayListAT_Confined_Space);
        lvPerson.setAdapter(AT_Confined_Space_listadaptor);

        Intent view= getIntent();
        new AT_Confined_Space_database.Wait().execute();

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
            return(arrayListAT_Confined_Space.size()==0);
        }

        @Override
        protected void onPostExecute(Boolean bool) {
            if(bool)
                updateView();
        }
    }

    public void startInspection() {

        Intent intent = new Intent(AT_Confined_Space_database.this, AT_Confined_Space_view.class);


        Date date = new Date();
        currentInspectionDate = DateFormat.getDateTimeInstance().format(date);

        // Add a date field to the person class, set the date as this dateString

        AT_Confined_Space_model AT_Confined_Space_model = new AT_Confined_Space_model();
        Map<String, Object> postValues = AT_Confined_Space_model.toMap();

        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Confined Space Form").child(currentInspectionDate).updateChildren(postValues);
        intent.putExtra("Date", currentInspectionDate);
        intent.putExtra("Position", -1);
        startActivity(intent);
    }

    public static AT_Confined_Space_database getInstance() {
        return AT_Confined_Space_database;
    }

    public ArrayList<String> getKeysArray() {
        return keysArray;
    }

    public DatabaseReference getmDatabase() {
        return mDatabase;
    }


    public void addAT_Confined_Space_model(AT_Confined_Space_model model) {
        AT_Confined_Space_model add = new AT_Confined_Space_model();
        add.setuser_name(model.getuser_name());
        add.setuser_email(model.getuser_email());
        add.setuser_department_area(model.getuser_department_area());
        add.setuser_contact_number(model.getuser_contact_number());
        add.setstartDate(model.getstartDate());
        add.setendDate(model.getendDate());

        ////////////////////////////////////////////////////////////////////////////////////////

        add.setcsform_generalppehivisvest(model.getcsform_generalppehivisvest());
        add.setcsform_generalppehardhat(model.getcsform_generalppehardhat());
        add.setcsform_generalppesafetyboots(model.getcsform_generalppesafetyboots());
        add.setcsform_generalppegloves(model.getcsform_generalppegloves());
        add.setcsform_generalppeoveralls(model.getcsform_generalppeoveralls());
        add.setcsform_generalppeglasses(model.getcsform_generalppeglasses());


        ////////////////////////////////////////////////////////////////////////////////////////

        add.setcsform_cs_level_1(model.getcsform_cs_level_1());
        add.setcsform_cs_level_2(model.getcsform_cs_level_2());
        add.setcsform_cs_level_3(model.getcsform_cs_level_3());


        ////////////////////////////////////////////////////////////////////////////////////////

        add.setcs_overalls(model.getcs_overalls());
        add.setcs_gasmonitor(model.getcs_gasmonitor());
        add.setcs_emergencycall(model.getcs_emergencycall());
        add.setcs_firstaid(model.getcs_firstaid());
        add.setcs_explosivelight(model.getcs_explosivelight());
        add.setcs_safetysigns(model.getcs_safetysigns());
        add.setcs_isolationsources(model.getcs_isolationsources());
        add.setcs_lifejacket(model.getcs_lifejacket());
        add.setcs_bumphat(model.getcs_bumphat());
        add.setcs_escapeset(model.getcs_escapeset());
        add.setcs_tripodharness(model.getcs_tripodharness());
        add.setcs_communication(model.getcs_communication());
        add.setcs_rescue(model.getcs_rescue());


        ////////////////////////////////////////////////////////////////////////////////////////





        Date date = new Date();
        String dateString = DateFormat.getDateTimeInstance().format(date);
        add.setendDate(dateString);

        add.setstartDate(currentInspectionDate);
        Map<String, Object> postValues = add.toMap();

        // Add a date field to the person class, set the date as this dateString

        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Confined Space Form").child(currentInspectionDate).updateChildren(postValues);
    }

    public void deletePerson(int position) {
        String clickedKey = keysArray.get(position);

        AT_Confined_Space_model p = arrayListAT_Confined_Space.get(position);


        mDatabase.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Confined Space Form").child(clickedKey).removeValue();
    }



    ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            lvPerson.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            Log.d(TAG, dataSnapshot.getKey() + ":" + dataSnapshot.getValue().toString());
            AT_Confined_Space_model person = dataSnapshot.getValue(AT_Confined_Space_model.class);

            arrayListAT_Confined_Space.add(person);
            keysArray.add(dataSnapshot.getKey());
            updateView();
        }
        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            String changedKey = dataSnapshot.getKey();
            int changedIndex = keysArray.indexOf(changedKey);
            AT_Confined_Space_model person = dataSnapshot.getValue(AT_Confined_Space_model.class);
            arrayListAT_Confined_Space.set(changedIndex,person);
            updateView();
        }
        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {
            String deletedKey = dataSnapshot.getKey();
            int removedIndex = keysArray.indexOf(deletedKey);
            keysArray.remove(removedIndex);
            arrayListAT_Confined_Space.remove(removedIndex);
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
        arrayListAT_Confined_Space.clear();
        mDatabase.removeEventListener(childEventListener);
    }

    public void updateView() {
        AT_Confined_Space_listadaptor.notifyDataSetChanged();
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