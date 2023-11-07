package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class TestDrive extends LinearOpMode {
    RobotHardware robot = new RobotHardware();

    @Override

    // toggle vars

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        boolean spikeServoCheck = false;
        boolean boardPixelCheck = false;
        boolean hangCheck = false;


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

            robot.frontLeft.setPower(frontLeftPower);
            robot.backLeft.setPower(backLeftPower);
            robot.frontRight.setPower(frontRightPower);
            robot.backRight.setPower(backRightPower);

            // non drive controls;
            //hang control
            if (gamepad1.x && !hangCheck) {
                robot.hangPivot.setTargetPosition(robot.hangRaise);
                robot.hangPivot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                hangCheck = true; // goes up to hang
            } else if (gamepad1.x && hangCheck) { // if it is already up, go down
                robot.hangPivot.setTargetPosition(robot.hangDown);
                robot.hangPivot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                hangCheck = false;
            }

            if (gamepad1.dpad_up) {
                robot.hangMotor.setPower(1);
            } else if (gamepad1.dpad_down) {
                robot.hangMotor.setPower(-1);
            } else {
                robot.hangMotor.setPower(0);
            }

            //intake control
            if (gamepad1.left_bumper) {
                robot.intakeMotor.setPower(robot.activeIntake);
            } else if (gamepad1.right_bumper) {
                robot.intakeMotor.setPower(robot.activeOuttake);
            } else robot.intakeMotor.setPower(robot.OuttakeHold);


            //all manual overrides driver for 2

            if (gamepad2.x && !spikeServoCheck) {
                robot.spikeServoPos(false);
                spikeServoCheck = true; // goes down
            } else if (gamepad2.x && spikeServoCheck) {
                robot.spikeServoPos(true);
                spikeServoCheck = false;
            }

            if (gamepad2.y && !boardPixelCheck) {
                robot.boardPixelPos(false);
                boardPixelCheck = true;
            } else if (gamepad2.y && boardPixelCheck) {
                robot.boardPixelPos(true);
                boardPixelCheck = false;
            }


        }
    }
}