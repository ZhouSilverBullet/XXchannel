package com.sdxxtop.trackerlibrary.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.sdxxtop.trackerlibrary.db.entity.TrackerPathEntry;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TRACKER_PATH_ENTRY".
*/
public class TrackerPathEntryDao extends AbstractDao<TrackerPathEntry, String> {

    public static final String TABLENAME = "TRACKER_PATH_ENTRY";

    /**
     * Properties of entity TrackerPathEntry.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Key = new Property(0, String.class, "key", true, "KEY");
        public final static Property IsComplete = new Property(1, boolean.class, "isComplete", false, "IS_COMPLETE");
        public final static Property IsPush = new Property(2, boolean.class, "isPush", false, "IS_PUSH");
        public final static Property CompanyId = new Property(3, String.class, "companyId", false, "COMPANY_ID");
        public final static Property UserId = new Property(4, String.class, "userId", false, "USER_ID");
        public final static Property StartTime = new Property(5, Long.class, "startTime", false, "START_TIME");
        public final static Property EndTime = new Property(6, Long.class, "endTime", false, "END_TIME");
        public final static Property Duration = new Property(7, Long.class, "duration", false, "DURATION");
        public final static Property Path = new Property(8, String.class, "path", false, "PATH");
    }


    public TrackerPathEntryDao(DaoConfig config) {
        super(config);
    }
    
    public TrackerPathEntryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TRACKER_PATH_ENTRY\" (" + //
                "\"KEY\" TEXT PRIMARY KEY NOT NULL ," + // 0: key
                "\"IS_COMPLETE\" INTEGER NOT NULL ," + // 1: isComplete
                "\"IS_PUSH\" INTEGER NOT NULL ," + // 2: isPush
                "\"COMPANY_ID\" TEXT," + // 3: companyId
                "\"USER_ID\" TEXT," + // 4: userId
                "\"START_TIME\" INTEGER," + // 5: startTime
                "\"END_TIME\" INTEGER," + // 6: endTime
                "\"DURATION\" INTEGER," + // 7: duration
                "\"PATH\" TEXT);"); // 8: path
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TRACKER_PATH_ENTRY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TrackerPathEntry entity) {
        stmt.clearBindings();
 
        String key = entity.getKey();
        if (key != null) {
            stmt.bindString(1, key);
        }
        stmt.bindLong(2, entity.getIsComplete() ? 1L: 0L);
        stmt.bindLong(3, entity.getIsPush() ? 1L: 0L);
 
        String companyId = entity.getCompanyId();
        if (companyId != null) {
            stmt.bindString(4, companyId);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(5, userId);
        }
 
        Long startTime = entity.getStartTime();
        if (startTime != null) {
            stmt.bindLong(6, startTime);
        }
 
        Long endTime = entity.getEndTime();
        if (endTime != null) {
            stmt.bindLong(7, endTime);
        }
 
        Long duration = entity.getDuration();
        if (duration != null) {
            stmt.bindLong(8, duration);
        }
 
        String path = entity.getPath();
        if (path != null) {
            stmt.bindString(9, path);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TrackerPathEntry entity) {
        stmt.clearBindings();
 
        String key = entity.getKey();
        if (key != null) {
            stmt.bindString(1, key);
        }
        stmt.bindLong(2, entity.getIsComplete() ? 1L: 0L);
        stmt.bindLong(3, entity.getIsPush() ? 1L: 0L);
 
        String companyId = entity.getCompanyId();
        if (companyId != null) {
            stmt.bindString(4, companyId);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(5, userId);
        }
 
        Long startTime = entity.getStartTime();
        if (startTime != null) {
            stmt.bindLong(6, startTime);
        }
 
        Long endTime = entity.getEndTime();
        if (endTime != null) {
            stmt.bindLong(7, endTime);
        }
 
        Long duration = entity.getDuration();
        if (duration != null) {
            stmt.bindLong(8, duration);
        }
 
        String path = entity.getPath();
        if (path != null) {
            stmt.bindString(9, path);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public TrackerPathEntry readEntity(Cursor cursor, int offset) {
        TrackerPathEntry entity = new TrackerPathEntry( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // key
            cursor.getShort(offset + 1) != 0, // isComplete
            cursor.getShort(offset + 2) != 0, // isPush
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // companyId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // userId
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // startTime
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6), // endTime
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // duration
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // path
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TrackerPathEntry entity, int offset) {
        entity.setKey(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setIsComplete(cursor.getShort(offset + 1) != 0);
        entity.setIsPush(cursor.getShort(offset + 2) != 0);
        entity.setCompanyId(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUserId(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setStartTime(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setEndTime(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
        entity.setDuration(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setPath(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final String updateKeyAfterInsert(TrackerPathEntry entity, long rowId) {
        return entity.getKey();
    }
    
    @Override
    public String getKey(TrackerPathEntry entity) {
        if(entity != null) {
            return entity.getKey();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TrackerPathEntry entity) {
        return entity.getKey() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
