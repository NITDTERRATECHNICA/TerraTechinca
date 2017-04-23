package delhi.android.nit.com.terratechnica.Contact;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import delhi.android.nit.com.terratechnica.R;

public class Contact_Us extends Fragment {

    private RecyclerView recyclerView;
    private ContactUsAdapter contactUsAdapter;
    private List<ContactsData> contactsData = new ArrayList<>();
    ImageView contactBG;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contact_us, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setData();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
//        contactUsAdapter = new ContactUsAdapter(contactsData);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        CategParent parent = new CategParent("List");

        ExpandableContactAdapter adapter = new ExpandableContactAdapter(getContext(), initData());

        recyclerView.setAdapter(adapter);

        contactBG = (ImageView) view.findViewById(R.id.contactBG);
        Glide.with(getActivity())
                .load(R.drawable.bg2)
                .crossFade()
                .centerCrop()
                .into(contactBG);

    }

    private List<ParentObject> initData() {
        CategCreator categCreator = CategCreator.get(getActivity());
        List<CategParent>  parents = categCreator.getAll();
        List<ParentObject> parentObjects = new ArrayList<>();
        int j=0;
        for(int i=0;i<parents.size();i++)
        {
            List<Object> childList = new ArrayList<>();
            CategChild categChild;

            switch (i + 1)
            {
                case 1:
                    childList.clear();
                    for(;j<=3;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 2:
                    childList.clear();
                    for(;j<=7;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 3:
                    childList.clear();
                    for(;j<=10;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 4:
                    childList.clear();
                    for(;j<=13;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 5:
                    childList.clear();
                    for(;j<=16;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 6:
                    childList.clear();
                    for(;j<=19;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 7:
                    childList.clear();
                    for(;j<=21;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 8:
                    childList.clear();
                    for(;j<=24;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 9:
                    childList.clear();
                    for(;j<=28;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 10:
                    childList.clear();
                    for(;j<=30;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 11:
                    childList.clear();
                    for(;j<=33;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 12:
                    childList.clear();
                    for(;j<=36;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 13:
                    childList.clear();
                    for(;j<=39;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 14:
                    childList.clear();
                    for(;j<=41;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 15:
                    childList.clear();
                    for(;j<=43;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                case 16:
                    childList.clear();
                    for(;j<=46;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
                    break;
                default:
                    childList.clear();
                    for(;j<=49;j++) {
                        categChild = new CategChild(contactsData.get(j));
                        childList.add(categChild);
                    }
            }
            parents.get(i).setChildObjectList(childList);
            parentObjects.add(parents.get(i));
        }
        return parentObjects;
    }


    private void setData() {

        contactsData.add(new ContactsData("Mohit Yadav","8802370556","mohit","Convener"));//1
        contactsData.add(new ContactsData("Jasleen Kaur","7838980689","jasleen","Co-Convener"));//2
        contactsData.add(new ContactsData("Bhupesh Kumar","9716848553","bhupesh","Co-Convener"));//3
        contactsData.add(new ContactsData("Shantanu Patil","9158121986","shantanu","Co-Convener"));//4


        contactsData.add(new ContactsData("Lakshya","8527546574","lakshya","Web Team"));//5
        contactsData.add(new ContactsData("Manojit Paul", "9650419350", "manojit", "Android Team"));//6
        contactsData.add(new ContactsData("Shivam Bathla", "8860032051", "shivam", "Android Team"));//7
        contactsData.add(new ContactsData("Ayush Pranav", "7289017595", "ayush", "Android Team"));//8

        contactsData.add(new ContactsData("Arpan Singh", "9058105581", "arpan", "VFX and Trailer"));//9
        contactsData.add(new ContactsData("Vishal Simon","9654474100","vishal","Head"));//10
        contactsData.add(new ContactsData("Aditya Kumar","9717514980","aditya","Sub-Head"));//11


        contactsData.add(new ContactsData("Anubhav Nautiyal","8826849926","anubhav","Head"));//12
        contactsData.add(new ContactsData("Anurag Giri","88002220624","anurag","Sub-Head"));//13
        contactsData.add(new ContactsData("Abha Khinoo","7011216731","abha","Sub-Head"));//14


        contactsData.add(new ContactsData("Amit Jakhar","8527268125","amit","Head"));//15
        contactsData.add(new ContactsData("Pradip Kathrotiya","9426495019","pradip","Sub-Head"));//16
        contactsData.add(new ContactsData("Aman Kumar","9911863023","aman","Sub-Head"));//17


        contactsData.add(new ContactsData("Jasleen Kaur","7838980689","jasleen","Head"));//18
        contactsData.add(new ContactsData("Himangi Chauhan","8800470874","himangi","Sub-Head"));//19
        contactsData.add(new ContactsData("Maneesh Behera","9899641483","maneesh","Sub-Head"));//20


        contactsData.add(new ContactsData("Bhupesh Kumar","9716848553","bhupesh","Head"));//21
        contactsData.add(new ContactsData("Deepak ","8059966459","deepak","Sub-Head"));//22


        contactsData.add(new ContactsData("Shubham Agarwal","9582512832","shubham","Head"));//23
        contactsData.add(new ContactsData("Yoga Reddy","8750267966","yoga","Sub-Head"));//24
        contactsData.add(new ContactsData("Sabeel Mohamed","8826855736","sabeel","Sub-Head"));//25


        contactsData.add(new ContactsData("Chamarthi Aditya","889730501","chamarthi","Head"));//26
        contactsData.add(new ContactsData("Akhilesh Kushwaha","8756565420","akhilesh","Sub-Head"));//27
        contactsData.add(new ContactsData("Shivani Gahlot","9717693879","shivani","Sub-Head"));//28
        contactsData.add(new ContactsData("Isha Saini","9718014326","isha","Sub-Head"));//29


        contactsData.add(new ContactsData("Anirudh Solanki","9045677424","anirudh","Head"));//30
        contactsData.add(new ContactsData("Aditya Bhawsar","9560423324","adityab","Sub-Head"));//31


        contactsData.add(new ContactsData("Parul Pant","9958961387","parul","Head"));//32
        contactsData.add(new ContactsData("Deepika Saini","9013950539","deepika","Sub-Head"));//33
        contactsData.add(new ContactsData("Avtansh Gupta","8743068185","avtansh","Sub-Head"));//34

        contactsData.add(new ContactsData("Rajnish Prajapati","9560297049","rajnish","Head"));//35
        contactsData.add(new ContactsData("Nishant Garg","9654962514","nishant","Sub-head"));//36
        contactsData.add(new ContactsData("Pushpita Majumdar","9874296178","pushpita","Sub-head"));//37


        contactsData.add(new ContactsData("Sunil Vaishnav","9716209524","sunil","Head"));//38
        contactsData.add(new ContactsData("Amit jangid","8233285595","amit","Sub-Head"));//39
        contactsData.add(new ContactsData("Aadil Ehsan","7210209309","aadil","Sub-Head"));//40


        contactsData.add(new ContactsData("Sanjana Jain","9910696284","sanjana","Head"));//41
        contactsData.add(new ContactsData("Ajay Meena","9313431684","ajaym","Sub-Head"));//42


        contactsData.add(new ContactsData("Naseeb","8287575539","naseeb",""));//43
        contactsData.add(new ContactsData("Mayank Sharma","8802293138","mayank",""));//44


        contactsData.add(new ContactsData("Deepak","8285115778","deepak","Head"));//45
        contactsData.add(new ContactsData("Aman Kumar","9911863023","aman","Sub-Head"));//46
        contactsData.add(new ContactsData("Nishant Singhal","9654962514","nishants","Sub-Head"));//47

        contactsData.add(new ContactsData("Rashad Mubarak","9810548849","rashad","Head"));//48
        contactsData.add(new ContactsData("Nita Mathew","9999625845","nita","Sub-Head"));//50
        contactsData.add(new ContactsData("Sonali Sethi","9711212758","sonali","Sub-Head"));//49

    }

}
