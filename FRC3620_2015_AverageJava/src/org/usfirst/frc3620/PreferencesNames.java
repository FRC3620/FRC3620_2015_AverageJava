/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc3620;

/**
 *
 * @author wegscd
 */
public class PreferencesNames {
  public static final String SLEW_LIMIT_VALUE = "Slew_limit_value";
  
  public static final String LIFT_BOTTOM_POSITION = "lift_bottom_position";
  public static final String LIFT_MIDDLE_POSITION = "lfit_middle_position";
  public static final String LIFT_TOP_POSITION = "lfit_top_position";
  
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
    public static final String AUTONOMOUS_CHOICE_LAND_FILL_1 = "Land Fill 1";
    public static final String AUTONOMOUS_CHOICE_LAND_FILL_2 = "Land Fill 2";
    public static final String AUTONOMOUS_CHOICE_LAND_FILL_3 = "Land Fill 3";
    public static final String AUTONOMOUS_CHOICE_LAND_FILL_4 = "Land Fill 4";
    public static final String AUTONOMOUS_CHOICE_LAND_FILL_5 = "Land Fill 5";
    
    public static final String JOY_STABAL_NONE = "None";
    public static final String JOY_STABAL_RAISE_TO_POWER = "raise to power";
    public static final String JOY_STABAL_SLEW_LIMIT = "slew limiter";
    public static final String JOY_STABAL_CHOICE = "joystick_stabalization_choice";

    public static final String[] AUTONOMOUS_ALL_CHOICES = new String[]{
        AUTONOMOUS_CHOICE_NONE,
        AUTONOMOUS_CHOICE_TOTE_AND_BIN,
        AUTONOMOUS_CHOICE_MOVE_ONLY,
        AUTONOMOUS_CHOICE_LAND_FILL_1,
        AUTONOMOUS_CHOICE_LAND_FILL_2,
        AUTONOMOUS_CHOICE_LAND_FILL_3,
        AUTONOMOUS_CHOICE_LAND_FILL_4,
        AUTONOMOUS_CHOICE_LAND_FILL_5,
    };
    
    public static final String[] JOY_STABAL_ALL_CHOICES = new String[]{
        JOY_STABAL_NONE,
        JOY_STABAL_RAISE_TO_POWER,
        JOY_STABAL_SLEW_LIMIT,
    };
    
  
}
