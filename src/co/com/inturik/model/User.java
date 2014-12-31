package co.com.inturik.model;

import com.zupcat.cache.CacheStrategy;
import com.zupcat.model.DatastoreEntity;
import com.zupcat.model.config.STRING;
import com.zupcat.property.StringProperty;

public class User extends DatastoreEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StringProperty FIRSTNAME;
    public StringProperty LASTNAME;

    public User() {
        // the instance will benefit from MemCache. 
        //It will expire after 15 minutes of inactivity
        super(CacheStrategy.SESSION_CACHE);
    }

    @Override
    protected void config() {
        FIRSTNAME = new STRING(this).build();
        LASTNAME = new STRING(this).build();
    }

}
