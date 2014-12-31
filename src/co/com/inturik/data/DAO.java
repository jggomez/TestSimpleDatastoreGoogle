package co.com.inturik.data;

import java.util.List;
import com.google.appengine.api.datastore.Query;
import co.com.inturik.model.User;

@SuppressWarnings("serial")
public class DAO extends com.zupcat.dao.DAO<User> {

	public DAO() {
		super(User.class);
	}

	public List<User> getByLastName(String lastName) {
		return findByQuery(new Query.FilterPredicate(
				sample.LASTNAME.getPropertyName(), Query.FilterOperator.EQUAL,
				lastName));
	}

}
