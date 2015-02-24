package org.usfirst.frc3620;

/**
 *
 * @author wegscd
 */
public class PreferencesNames {
  public static final String TEST_SLIDER = "test_slider";
  
    public static final String CRIONAME = "crioname";
    public static final String AUTONOMOUS_FORWARD_DISTANCE = "autonomous_forward_distance";
    public static final String AUTONOMOUS_CHOICE = "autonomous_choice";
    public static final String CHOOCHOO_DELAY = "choochoo_delay";
    public static final String INTAKE_SPEED = "intake_speed";
    public static final String HUE_LOWER = "hue_lower";
    public static final String HUE_UPPER = "hue_upper";
    public static final String SATURATION_LOWER = "saturation_lower";
    public static final String SATURATION_UPPER = "saturation_upper";
    public static final String VALUE_LOWER = "value_lower";
    public static final String VALUE_UPPER = "value_upper";
    
    public static final String AUTONOMOUS_CHOICE_NONE = "None";
    public static final String AUTONOMOUS_CHOICE_TOTE_AND_BIN = "Tote and bin";
    public static final String AUTONOMOUS_CHOICE_MOVE_ONLY = "Move Only";
    
    public static final String JOY_STABAL_NONE = "None";
    public static final String JOY_STABAL_VED = "Ved";
    public static final String JOY_STABAL_PATRICK = "Patrick";
    public static final String JOY_STABAL_CHOICE = "joystick stabalization choice";

    public static final String[] AUTONOMOUS_ALL_CHOICES = new String[]{
        AUTONOMOUS_CHOICE_NONE,
        AUTONOMOUS_CHOICE_TOTE_AND_BIN,
        AUTONOMOUS_CHOICE_MOVE_ONLY,
    };
    
    public static final String[] JOY_STABAL_ALL_CHOICES = new String[]{
        JOY_STABAL_NONE,
        JOY_STABAL_VED,
        JOY_STABAL_PATRICK,
    };
    
  
}