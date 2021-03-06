package org.hwyl.sexytopo;

import android.content.Context;
import android.os.Environment;

import org.hwyl.sexytopo.control.util.TextTools;

import java.io.File;
import java.util.UUID;


public class SexyTopo {

    public static final String APP_NAME = "SexyTopo";
    public static final String VERSION = "1.0.11";

    public static final String TAG = APP_NAME; // for writing debug log

    public static final UUID DISTO_X_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    public static final int NUM_OF_REPEATS_FOR_NEW_STATION = 3;

    public static final String SURVEY_UPDATED_EVENT = "surveyUpdatedEvent";
    public static final String DEVICE_LOG_UPDATED_EVENT = "deviceLogUpdatedEvent";

    private static final String EXTERNAL_ROOT = Environment.getExternalStorageDirectory().toString();
    public static final String APP_DIR = APP_NAME;
    public static final String SURVEY_DIR = "Surveys";
    public static final String IMPORT_DIR = "To Import";
    public static final String EXPORT_DIR = "Exported";
    public static final String EXTERNAL_SURVEY_DIR =
            TextTools.joinAll(File.separator, EXTERNAL_ROOT, APP_DIR, SURVEY_DIR);
    public static final String EXTERNAL_IMPORT_DIR =
            TextTools.joinAll(File.separator, EXTERNAL_ROOT, APP_DIR, IMPORT_DIR);
    public static final String EXTERNAL_EXPORT_DIR =
            TextTools.joinAll(File.separator, EXTERNAL_ROOT, APP_DIR, EXPORT_DIR);

    public static final String IMPORT_SOURCE_DIR = "Import Source";

    public static final String ACTIVE_SURVEY_NAME = "activeSurveyName";

    public static final String BLANK_STATION_NAME = "-";

    public static final String GENERAL_PREFS = "generalPrefs";
    public static final String REVERSE_MEASUREMENTS_PREFERENCE = "reverseMeasurements";

    public static final String PLAN_SKETCH_EXTENSION = "plan.json";
    public static final String EXT_ELEVATION_SKETCH_EXTENSION = "ext-elevation.json";

    public static final double ALLOWED_DOUBLE_DELTA_FOR_TESTS = 0.0001;

    // This is extremely hacky but quite useful for getting a context when it's not sensible
    // to pass one around
    public static Context context;
}
