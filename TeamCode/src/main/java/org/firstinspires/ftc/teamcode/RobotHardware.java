package org.firstinspires.ftc.teamcode;

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
    public int hangRaise = 10000;
    public int hangDown = 0;

    public double activeIntake = 1;
    public double activeOuttake = -1;
    public double OuttakeHold = 0.2;
    public DcMotor frontLeft     = null;
    public DcMotor backLeft      = null;
    public DcMotor frontRight    = null;
    public DcMotor backRight    = null;

    public DcMotor intakeMotor = null;

    public DcMotor hangPivot = null;
    public DcMotor hangMotor = null;




    public Servo   spikeMarkDrop    = null;
    public Servo   boardPixelDrop     = null;




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
        hangPivot = hwMap.dcMotor.get("hangRaise");
        hangMotor = hwMap.dcMotor.get("hangMotor");




        // Set direction for all motors
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        hangPivot.setDirection(DcMotor.Direction.FORWARD);
        hangMotor.setDirection(DcMotor.Direction.FORWARD);







        // Set all motors to zero power
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        intakeMotor.setPower(0);
        hangPivot.setPower(0);





        // Set all motors to use brake mode
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hangPivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hangMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);




        // Set almost all motors to run with encoders
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        hangPivot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        hangPivot.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // set default pos to down
        hangPivot.setTargetPosition(hangDown);
        hangPivot.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        // Define and initialize all installed servos
        boardPixelDrop = hwMap.servo.get("board");
        spikeMarkDrop = hwMap.servo.get("spike");

        // set servo default pos;
        spikeMarkDrop.setPosition(.45);

    }
    /**
     * spikeServoPos Sets Spike Servo position
     * @param spikeServoDirection Sets servo direction up/down | true = up, false = down
     */
    public void spikeServoPos (boolean spikeServoDirection) {
        if(spikeServoDirection) {
            spikeMarkDrop.setPosition(.45); // up
        } else if(!spikeServoDirection) {
            spikeMarkDrop.setPosition(-.8); // down
        }
    }
    public void boardPixelPos(boolean boardPixelDirection) {
        if(boardPixelDirection) {
            boardPixelDrop.setPosition(.45); // up
        } else if(!boardPixelDirection) {
            boardPixelDrop.setPosition(-.8); // down
        }

    }
}