package delhi.android.nit.com.terratechnica.Contact;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by directioner on 10/4/17.
 */

public class CategParent implements ParentObject {

    private List<Object> childList;
    private UUID _id;
    private String title;

    public CategParent(String title) {
        this.title = title;
        _id = UUID.randomUUID();
    }

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public List<Object> getChildObjectList() {
        return childList;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        childList = list;
    }
}
