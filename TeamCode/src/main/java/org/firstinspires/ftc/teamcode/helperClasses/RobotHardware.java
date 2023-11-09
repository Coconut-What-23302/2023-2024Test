package org.firstinspires.ftc.teamcode.helperClasses;

//import com.qualcomm.robotcore.hardware.AnalogInput;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * This is NOT an opmode.
 * This class is used to define all the specific hardware for a single robot.
 */

public class RobotHardware
{


    /* Public OpMode members. */
    public DcMotor frontLeft     = null;
    public DcMotor backLeft      = null;
    public DcMotor frontRight    = null;
    public DcMotor backRight    = null;

    public DcMotor intakeMotor = null;

    public DcMotor hangLeadScrewMotor = null;
    public DcMotor hangPivotMotor = null;

    public Servo   spikeMarkDrop    = null;
    public Servo   boardPixelDrop     = null;

    // final variables

    public final double intakeDefaultPower = -.55;
    public final double fullOuttake = 1;
    public final double fullIntake = -1;

    public final int pivotUp = 343;
    public final int pivotDown = -1;




    //    public AnalogInput potentiometer  = null;
    HardwareMap    hwMap              = null;

    /* Constructor */
    public RobotHardware() {

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and initialize motors
        frontLeft  = hwMap.dcMotor.get("frontLeft");
        backLeft  = hwMap.dcMotor.get("backLeft");
        frontRight = hwMap.dcMotor.get("frontRight");
        backRight = hwMap.dcMotor.get("backRight");
        intakeMotor = hwMap.dcMotor.get("spiny");
        hangLeadScrewMotor = hwMap.dcMotor.get("hangLeadScrew");
        hangPivotMotor = hwMap.dcMotor.get("hangPivot");




        // Set direction for all motors
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        hangLeadScrewMotor.setDirection(DcMotor.Direction.FORWARD);
        hangPivotMotor.setDirection(DcMotor.Direction.FORWARD);







        // Set all motors to zero power
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        intakeMotor.setPower(0);
        hangLeadScrewMotor.setPower(0);
        hangPivotMotor.setPower(1);






        // Set all motors to use brake mode
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hangLeadScrewMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hangPivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        hangPivotMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);



        // Set almost all motors to run with encoders
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        hangLeadScrewMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



        // Define and initialize all installed servos
        boardPixelDrop = hwMap.servo.get("board");
        spikeMarkDrop = hwMap.servo.get("spike");

        // set servo default pos;
        spikeMarkDrop.setPosition(.5);

        boardPixelDrop.setPosition(1);

    }
    /**
     * spikeServoPos Sets Spike Servo position
     * @param direction Sets servo direction up/down | true = up, false = down
     */
public void spikeServoPos (boolean direction) {
    if(direction) {
        spikeMarkDrop.setPosition(.48); // up
    } else if(!direction) {
        spikeMarkDrop.setPosition(.22); // down
    }
}
    /**
     * boardPixelServoPos Sets Spike Servo position
     * @param direction Sets servo direction up/down | true = up, false = down
     */
    public void boardPixelServoPos (boolean direction) {
        if(direction) {
            boardPixelDrop.setPosition(1); // up
        } else if(!direction) {
            boardPixelDrop.setPosition(.5); // down
        }
    }
    /**
     * hangPivotPos Sets hang motor position
     * @param direction Sets motor direction up/down | true = up, false = down
     */
    public void hangPivotPos (boolean direction) {
        if(direction) {
           hangPivotMotor.setTargetPosition(pivotUp); // up
            hangPivotMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        } else if(!direction) {
            hangPivotMotor.setTargetPosition(pivotDown); // down
            hangPivotMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }





}