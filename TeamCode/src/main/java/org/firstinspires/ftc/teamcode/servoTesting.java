package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.helperClasses.RobotHardware;

@TeleOp
public class servoTesting extends LinearOpMode {
    RobotHardware robot = new RobotHardware();
    @Override

    // toggle vars

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        boolean spikeServoCheck = false;
        boolean boardServoCheck = false;




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

//            // non drive controls;
//            if(gamepad1.right_bumper) {
//                robot.intakeMotor.setPower(robot.fullOuttake);
//            } else if (gamepad1.left_bumper) {
//                robot.intakeMotor.setPower(robot.fullIntake);
//            }
////            else {
////                robot.intakeMotor.setPower(robot.intakeDefaultPower);
////            }

            if (gamepad1.dpad_up) {
                robot.hangLeadScrewMotor.setPower(1);
            } else if (gamepad1.dpad_down) {
                robot.hangLeadScrewMotor.setPower(-1);
            } else {
                robot.hangLeadScrewMotor.setPower(0);
            }


            //all manual overrides driver for 2
            if(gamepad2.x && !spikeServoCheck) {
//                robot.spikeServoPos(false);
                spikeServoCheck = true; // goes down
            } else if (gamepad2.x && spikeServoCheck) {
//                robot.spikeServoPos(true);
                spikeServoCheck = false;
            }

            if(gamepad2.y && !boardServoCheck) {
//                robot.boardPixelServoPos(false);
                boardServoCheck = true; // goes down
            } else if (gamepad2.y && boardServoCheck) {
//                robot.boardPixelServoPos(true);
                boardServoCheck = false;
            }




//             manual overrides driver 2





//            telemetry.addData("board Servo", robot.boardPixelDrop.getPosition());
            telemetry.update();










        }
    }
}