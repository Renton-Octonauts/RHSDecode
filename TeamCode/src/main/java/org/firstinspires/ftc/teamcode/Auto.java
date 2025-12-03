package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Hardware;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.teamcode.Mechanics.AprilTagWebcam;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name= "Auto")
public class Auto extends LinearOpMode {
    public int mode = defaultMode(); // 1 is default meaning we are blue
    Hardware hw = Hardware.getInstance(this);
    private AprilTagWebcam aprilTagWebcam;

        // yo gurt we havent said that in a while

    @Override
    public void runOpMode() {
        hw = Hardware.getInstance(this);
        hw.init(hardwareMap);
        hw.setToNoEncoder();

        // Initialize webcam here (inside a method)
        aprilTagWebcam = new AprilTagWebcam(); // or new AprilTagWebcam(this) depending on API
        aprilTagWebcam.init(hardwareMap, telemetry); // if needed by that class

        telemetry.addData("Mode", mode);
        telemetry.update();

        double shootDistance = 48.0; // Shooting distance in inches
        boolean ballCollected = false; // If ball collection is finished

        waitForStart();

        while(opModeIsActive()) {
            aprilTagWebcam.update();
            AprilTagDetection id20 = aprilTagWebcam.getTagBySpecificId(20);
            aprilTagWebcam.displayDetectionTelemetry(id20);
            if (id20 != null && id20.ftcPose != null) {
                double dx = id20.ftcPose.x;
                double dy = id20.ftcPose.y;
                double dz = id20.ftcPose.z;
                double distance = Math.sqrt(dx*dx + dy*dy + dz*dz);
                telemetry.addData("Distance (in)", distance);
            }

            switch(mode) {
                case 1: // Blue Top
                    System.out.println("Hello World");
                    break;
                case 2: // Red Top
                    System.out.println("Hello world1");
                    break;
                case 3: // Blue Bottom
                    System.out.println("Hello World2");
                    break;
                case 4: // Red Bottom
                    System.out.println("Hello World3");
                    break;
            }
            aprilTagWebcam.displayDetectionTelemetry(id20);

            telemetry.update();
        }
    }

    public int defaultMode() {
        return 1;
    }

    public void ballCollectBlue() { // Collect balls from the blue side top 

        while(!ballCollected) {

        // TODO GET A SENSOR INSIDE THE ROBOT
        if(sensor does not detect ball in the thing) {
            strafe left go forward and intake
                    if(ball is in) {
                make it go back to that ultimate position
            }
        }
        }

    }
    
    public void ballCollectRed() { // Instead of left, we go right
        while(something that I havent decided on yet) {

        if(sensor does not detect ball in the thing) {
            strafe left go forward and intake
                    if(ball is in) {
                make it go back to that ultimate position
            }
        }
        }
    }

    private void BlueTop() {

        // TODO Move back, shoot all preloaded balls, move back to a specific location which will be the same as the blue bottom when it's done shooting.

        aprilTagWebcam.update();
        AprilTagDetection id20 = aprilTagWebcam.getTagBySpecificId(20);
        aprilTagWebcam.displayDetectionTelemetry(id20);

        while(distance <= shootDistance) { // In inches
            hw.setPower(-1);
        }
        if(distance == shootDistance) {
            hw.setPower(0);
            hw.shooterMotor.setPower(1);
            sleep(2000); // TODO fix later
        }

        ballCollectBlue();
    }

    private void RedTop() {

        // TODO Move back, shoot all preloaded balls, move back to a specific location which will be the same as the red bottom when it's done shooting.

        aprilTagWebcam.update();
        AprilTagDetection id24 = aprilTagWebcam.getTagBySpecificId(24);
        aprilTagWebcam.displayDetectionTelemetry(id24);

        while(distance <= shootDistance) { // In inches
            hw.setPower(-1);
        }
        if(distance == shootDistance) {
            hw.setPower(0);
            hw.shooterMotor.setPower(1);
            sleep(2000); // TODO fix later
        }

        ballCollectRed();
    }

    // TODO THESE MIGHT BE WRONG BECAUSE OF THIS VIBE CODED SLOP
    private void BlueBottom() {

        // TODO Move up to goal post, shoot, then move back to a specific location which will be the same as the blue top when it's done shooting.

        while(distance != shootDistance) {
            hw.setPower(1);
        }
        if(distance == shootDistance) {
            hw.setPower(0);
            sleep(250); // TODO adjust later
            hw.rightSidePower(1);
            sleep(500); // TODO adjust later
            hw.shooterMotor.setPower(1);
            sleep(2000); // TODO fix later
        }

        ballCollectBlue();
    }

    // Fix this depending on where the robot is actually placed on the back, just in case it isn't what we think
    private void RedBottom() {

        // TODO Move up to goal post, shoot, then move back to a specific location which will be the same as the red top when it's done shooting.

        while(distance != shootDistance) { // Have to call distance because distance is going to be set as the robot distance from anything on the field
            hw.setPower(1); // if the robot is using the intake as the front
        }
        if(distance == shootDistance) {
            hw.setPower(0);
            sleep(250); // TODO adjust later
            hw.leftSidePower(1);
            sleep(500); // TODO adjust later
            hw.shooterMotor.setPower(1);
            sleep(2000); // TODO fix later
        }

        ballCollectRed();
    }
}
