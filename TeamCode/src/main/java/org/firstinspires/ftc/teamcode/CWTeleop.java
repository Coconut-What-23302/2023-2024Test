package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.helperClasses.PoseStorage;
import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;

@TeleOp
public class CWTeleop extends LinearOpMode {
    RobotHardware robot = new RobotHardware();

    @Override

    // toggle vars

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        boolean spikeServoCheck = false;
        boolean boardServoCheck = false;
        boolean intakeCheck = false;
        boolean manualOverride = false;
        robot.clawarm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.clawarm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//    boolean hangPivotCheck = false;
        boolean clawMoveCheck = false;
        int armPoisition = 0;




        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;


            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;
            double hangPivotPower = gamepad2.left_stick_y;
            robot.frontLeft.setPower(frontLeftPower);
            robot.backLeft.setPower(backLeftPower);
            robot.frontRight.setPower(frontRightPower);
            robot.backRight.setPower(backRightPower);


            // non drive controls;
            robot.hangPivotMotor.setPower(hangPivotPower); // set hang pivot motor to negative power of


            if (gamepad1.a) {
                armPoisition = armPoisition + 2;
            }
            else if (gamepad1.b) {
                armPoisition = 69696969;
            }
            else if (gamepad1.left_bumper){
                armPoisition = -696969;
            }
            else if (gamepad2.right_bumper){
                armPoisition = armPoisition -2;
            }
            robot.clawarm.setPower(0.70);
            robot.clawarm.setTargetPosition(armPoisition);



            if (gamepad1.dpad_up) {
                robot.hangLeadScrewMotor.setPower(1);
            } else if (gamepad1.dpad_down) {
                robot.hangLeadScrewMotor.setPower(-1);
            } else {
                robot.hangLeadScrewMotor.setPower(0);
            }


                //all manual overrides driver for 2
                if (gamepad2.x && !spikeServoCheck) {
                    robot.spikeServoPos(false);
                    spikeServoCheck = true; // goes down
                } else if (gamepad2.x && spikeServoCheck) {
                    robot.spikeServoPos(true);
                    spikeServoCheck = false;
                }

                if (gamepad2.y && !boardServoCheck) {
                    robot.boardPixelServoPos(false);
                    boardServoCheck = true; // goes down
                } else if (gamepad2.y && boardServoCheck) {
                    robot.boardPixelServoPos(true);
                    boardServoCheck = false;
                }


//             manual overrides driver 2


                telemetry.addData("claw arm position", robot.clawarm.getCurrentPosition());
                telemetry.update();


            }
        }
    }


