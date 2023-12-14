package org.firstinspires.ftc.teamcode.helperClasses;

//import com.qualcomm.robotcore.hardware.AnalogInput;

import static android.os.SystemClock.sleep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvWebcam;

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

    public DcMotor clawArm = null;
    public DcMotor hangLeadScrewMotor = null;
    public DcMotor hangPivotMotor = null;

    public Servo   leftClaw    = null;
    public Servo     rightClaw   = null;
    public Servo clawWrist = null;

    public Servo planeLaunch = null;



    // final variables

    public final double intakeDefaultPower = 0;
    public final int fullOuttake = 0;
    public final int fullIntake = 70;

    public final int clawFullUp = 0;

    public final double rightClawClose = .45;

    public final double leftClawClose = .45;

          public final double rightClawOpen= .34 ;

        public final double leftClawOpen = .65;


    public final int clawFullDown = 587;

    public final int clawArmFirstBack = 270;

    public final int clawArmSecondBack = 0;





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
        clawArm = hwMap.dcMotor.get("clawArm");
        hangLeadScrewMotor = hwMap.dcMotor.get("hangRaise");
        hangPivotMotor = hwMap.dcMotor.get("hangPivot");




        // Set direction for all motors
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        clawArm.setDirection(DcMotor.Direction.FORWARD);
        hangLeadScrewMotor.setDirection(DcMotor.Direction.FORWARD);
        hangPivotMotor.setDirection(DcMotor.Direction.REVERSE);







        // Set all motors to zero power
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        hangLeadScrewMotor.setPower(0);
        hangPivotMotor.setPower(0);
        clawArm.setPower(0);

        clawArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);






        // Set all motors to use brake mode
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        clawArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hangLeadScrewMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hangPivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);








        // Set almost all motors to run with encoders
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        clawArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        hangLeadScrewMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        hangPivotMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        clawArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        clawArm.setTargetPosition(0);
        clawArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);




        // Define and initialize all installed servos
        leftClaw = hwMap.servo.get("rightClaw");
        rightClaw = hwMap.servo.get("leftClaw");
        clawWrist = hwMap.servo.get("clawWrist");
        planeLaunch = hwMap.servo.get("planeLaunch");


        // set servo default pos;



        // define and init sensors


    }

    /**
     * boardPixelServoPos Sets Spike Servo position
     *  Sets servo direction up/down | true = up, false = down
     */
    public void clawArmPosition (boolean position) {
        if(position) {
            clawArm.setTargetPosition(clawArmFirstBack);
            clawArm.setPower(.5);
            clawArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        } else if(!position) {
            clawArm.setTargetPosition(clawFullDown);
            clawArm.setPower(.5);
            clawArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }

    public void clawPos (double leftPos, double rightPos) {
        leftClaw.setPosition(leftPos);
        rightClaw.setPosition(rightPos);
    }


    public void clawPosBoth (boolean position) {
       if(position) {
           leftClaw.setPosition(leftClawOpen);
              rightClaw.setPosition(rightClawOpen);
       } else if(!position) {
           leftClaw.setPosition(leftClawClose);
           rightClaw.setPosition(rightClawClose);
       }
    }

    public void dumbWayToDriveToPosition (Pose2d inputPose, Pose2d currentPose) {
        double powerVal = 0;
        if (inputPose.getY() > currentPose.getY()) {
             powerVal = .5;
        }

        else if (inputPose.getY() < currentPose.getY())
        {
            powerVal = -.5;
        }

        do {


            backLeft.setPower(0.5);
            backRight.setPower(0.5);
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            sleep(250);


        }
        while ((inputPose.getY() * 2) > ((currentPose.getY() * 2)-4 ) || (inputPose.getY() * 2) > ((currentPose.getY() * 2) + 2)) ;






        backLeft.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
    }



}