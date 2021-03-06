package org.hwyl.sexytopo.control.io.basic;

import org.apache.commons.io.FileUtils;
import org.hwyl.sexytopo.SexyTopo;
import org.hwyl.sexytopo.control.io.thirdparty.survex.SurvexExporter;
import org.hwyl.sexytopo.control.io.Util;
import org.hwyl.sexytopo.model.sketch.Sketch;
import org.hwyl.sexytopo.model.survey.Survey;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;


/**
 * The entry point for saving survey and sketch data.
 */
public class Saver {

    public static final String AUTOSAVE_EXTENSION = ".autosave";


    public static void save(Survey survey) throws IOException, JSONException {

        if (survey.getName().equals("")) {
            throw new IllegalArgumentException("Not saved; survey name cannot be empty");
        } else if (survey.getName().contains("/")) {
            throw new IllegalArgumentException("Not saved; survey name cannot contain a slash");
        }

        saveSurveyData(survey, "svx");
        saveSketch(survey, survey.getPlanSketch(), SexyTopo.PLAN_SKETCH_EXTENSION);
        saveSketch(survey, survey.getElevationSketch(), SexyTopo.EXT_ELEVATION_SKETCH_EXTENSION);
        survey.setSaved(true);
    }


    public static void autosave(Survey survey) throws IOException, JSONException {
        saveSurveyData(survey, "svx" + "." + AUTOSAVE_EXTENSION);
        saveSketch(survey, survey.getPlanSketch(),
                SexyTopo.PLAN_SKETCH_EXTENSION + "." + AUTOSAVE_EXTENSION);
        saveSketch(survey, survey.getElevationSketch(),
                SexyTopo.EXT_ELEVATION_SKETCH_EXTENSION + "." + AUTOSAVE_EXTENSION);
    }


    private static void saveSurveyData(Survey survey, String extension)
            throws IOException {
        String path = Util.getPathForSurveyFile(survey.getName(), extension);
        String surveyText = new SurvexExporter().getContent(survey);
        saveFile(path, surveyText);
    }


    private static void saveSketch(Survey survey, Sketch sketch, String extension)
            throws IOException, JSONException {
        String path = Util.getPathForSurveyFile(survey.getName(), extension);
        String planText = SketchJsonTranslater.translate(sketch);
        saveFile(path, planText);
    }



    public static void saveFile(String path, String contents) throws IOException {

        File filePath = new File(path);
        String location = filePath.getParentFile().getPath();
        Util.ensureDirectoriesInPathExist(location);


        FileUtils.writeStringToFile(filePath, contents);

    }

}
