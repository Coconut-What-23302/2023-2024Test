package org.firstinspires.ftc.teamcode;

//import com.qualcomm.robotcore.hardware.AnalogInput;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
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




    public Servo   spikeMarkDrop    = null;
    public Servo   boardPixelDrop     = null;

    public Servo hangDeployServo = null;



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




        // Set direction for all motors
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);





        // Set all motors to zero power
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        intakeMotor.setPower(0);





        // Set all motors to use brake mode
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);




        // Set almost all motors to run with encoders
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



        // Define and initialize all installed servos
        boardPixelDrop = hwMap.servo.get("board");
        spikeMarkDrop = hwMap.servo.get("spike");
        hangDeployServo = hwMap.servo.get("hang");

        // set servo default pos
        hangDeployServo.setPosition(0);
//        boardPixelDrop.setPosition(-1);


    }

    /**
     * DrivePowerAll sets all of the drive train motors to the specified power level.
     * @param power Power level to set all motors to
     */
    void DrivePowerAll (double power)
    {
        driveSetPower(power, power, power, power);
    }

    /**
     * driveSetPower sets all of the drive train motors to the specified power levels.
     * @param flPower Power level to set front left motor to
     * @param frPower Power level to set front right motor to
     * @param blPower Power level to set back left motor to
     * @param brPower Power level to set back right motor to
     */
    void driveSetPower (double flPower, double frPower, double blPower, double brPower)
    {
        frontLeft.setPower(flPower);
        frontRight.setPower(frPower);
        backLeft.setPower(blPower);
        backRight.setPower(brPower);
    }

    /**
     * driveSetMode sets all of the drive train motors to the specified mode.
     * @param runmode RunMode to set motors to
     */
    void driveSetMode(DcMotor.RunMode runmode)
    {
        frontLeft.setMode(runmode);
        frontRight.setMode(runmode);
        backLeft.setMode(runmode);
        backRight.setMode(runmode);
    }


}