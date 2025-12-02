package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Hardware;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name= "Auto")
public class Auto extends LinearOpMode {
    public int mode = defaultMode(); // 1 is default meaning we are blue
    Hardware hw = Hardware.getInstance(this);
    private AprilTagWebcam aprilTagWebcam;



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

        waitForStart();

        while(opModeIsActive()) {

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

            telemetry.update();
        }
    }

    public int defaultMode() {
        return 1;
    }

    private void BlueTop() {
        aprilTagWebcam.update();
        AprilTagDetection id20 = aprilTagWebcam.getTagBySpecificId(20);
        aprilTagWebcam.displayDetectionTelemetry(id20);

        while(distance is less than not equal to yada yada yada) {
            move backwards
        }
        if(distance is equal to distance) {
            shoot
        }

        while(something that I havent decided on yet) {

        if(sensor does not detect ball in the thing) {
            strafe left go forward and intake
                    if(ball is in) {
                make it go back to that ultimate position
            }
        }
        }
    }

    private void RedTop() {
        // same thing from the other one except opposite
    }

    private void BlueBottom() {
        while(distance isnt distance) {
            move
        }
        if(distance is distance) {
            shoot
        }
        And then do the collect ball thing from the other one
    }

    private void RedBottom() {
        // same thing from the other one and I think we just copy the red top for the rest of it.
    }
}
