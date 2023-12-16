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

        boolean ArmCheck = false;
        boolean boardServoCheck = false;
        boolean intakeCheck = false;
        boolean manualOverride = false;
//    boolean hangPivotCheck = false;
        boolean clawMoveCheck = false;
        int armPoisition = 0;
        boolean ArmCheck2 = true;
        boolean clawCheck2 = false;
        boolean clawCheck = false;





        waitForStart();

        if (isStopRequested()) return;

        robot.clawArm.setPower(.5);

        while (opModeIsActive()) {

            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

//            robot.clawWrist.setPosition(0);

//            robot.rightClaw.setPosition(.53);
//
//            robot.leftClaw.setPosition(.0006);

            robot.clawWrist.setPosition(0.2);



            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;
            double hangPivotPower = gamepad2.left_stick_y * 0.5;
            robot.frontLeft.setPower(frontLeftPower * .75);
            robot.backLeft.setPower(backLeftPower * .75);
            robot.frontRight.setPower(frontRightPower * .75);
            robot.backRight.setPower(backRightPower * .75);


            // non drive controls;
            robot.hangPivotMotor.setPower(hangPivotPower); // set hang pivot motor to negative power of

            if (gamepad1.a && !ArmCheck) {

                ArmCheck = true; // goes down
            }
            if (!gamepad1.a && ArmCheck) {
                ArmCheck = false;
                ArmCheck2 = !ArmCheck2;
                armPoisition = robot.clawArmPosition(ArmCheck2);
            }

            if (gamepad1.left_bumper){
                armPoisition += 3;
            }

            if (gamepad1.right_bumper){
                armPoisition -= 3;
            }
            robot.clawArm.setTargetPosition(armPoisition);

            if (gamepad1.left_stick_button && gamepad1.right_stick_button){
                robot.clawArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                armPoisition = 0;
                robot.clawArm.setTargetPosition(0);
                robot.clawArm.setPower(0.5);
                robot.clawArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }

            if (gamepad1.x && !clawCheck) {

                clawCheck = true; // goes down
            }
            if (!gamepad1.x && clawCheck) {
                clawCheck = false;
                clawCheck2 = !clawCheck2;
            }

            robot.clawPosBoth(clawCheck2);


            if (gamepad2.b){
                robot.planeLaunch.setPosition(1);
            }



            if (gamepad2.dpad_up || gamepad1.dpad_up) {
                robot.hangLeadScrewMotor.setPower(1);
            } else if (gamepad2.dpad_down || gamepad1.dpad_down) {
                robot.hangLeadScrewMotor.setPower(-1);
            } else {
                robot.hangLeadScrewMotor.setPower(0);
            }







//             manual overrides driver 2


                telemetry.addData("claw arm position", robot.clawArm.getCurrentPosition());
                telemetry.update();


            }
        }
    }


