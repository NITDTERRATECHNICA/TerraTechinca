package delhi.android.nit.com.terratechnica.Contact;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by directioner on 10/4/17.
 */

public class CategCreator{
    static CategCreator creator;
    List<CategParent> parent;

    public CategCreator(Context context) {
        parent = new ArrayList<>();

        parent.add(new CategParent("Convener"));
        parent.add(new CategParent("Developers"));
        parent.add(new CategParent("Design Team"));
        parent.add(new CategParent("Event Managers"));
        parent.add(new CategParent("Infrastructure & Logistics"));
        parent.add(new CategParent("Lecture & Workshop"));
        parent.add(new CategParent("Finance & Purchase"));
        parent.add(new CategParent("PR & Sponsorship"));
        parent.add(new CategParent("Marketing & Publicity"));
        parent.add(new CategParent("Electrical & Fire Safety"));
        parent.add(new CategParent("Social Media Coverage"));
        parent.add(new CategParent("Hostel Accomodation"));
        parent.add(new CategParent("Discipline & Security"));
        parent.add(new CategParent("Hospitality"));
        parent.add(new CategParent("Transport & Parking"));
        parent.add(new CategParent("Stage Management"));
        parent.add(new CategParent("Prize Distribution"));
    }

    public static CategCreator get(Context context) {
        if (creator == null)
            creator = new CategCreator(context);
        return creator;
    }

    public List<CategParent> getAll() {
        return parent;
    }
}
