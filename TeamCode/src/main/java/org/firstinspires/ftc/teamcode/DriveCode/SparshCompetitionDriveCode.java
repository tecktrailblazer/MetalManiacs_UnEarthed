package org.firstinspires.ftc.teamcode.DriveCode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class SparshCompetitionDriveCode {

    DcMotor motorRight; // Assigning Motors//
    DcMotor motorLeft; // Assigning Motors//
    DcMotor motorArm; // Assigning Motors//
    Servo servoLeft;
    Servo servoRight;
    GamepadEx controller;

    public void init(){
        motorRight = hardwareMap.get(DcMotor.class,"motorRight"); // Defining Motors on the Robot//
        motorLeft = hardwareMap.get(DcMotor.class,"motorLeft"); // Defining Motors on the Robot//
        motorArm = hardwareMap.get(DcMotor.class,"motorArm"); // Defining Motors on the Robot//
        servoLeft = hardwareMap.get(Servo.class,"servoLeft");
        servoRight = hardwareMap.get(Servo.class,"servoRight");
        controller = new GamepadEx(gamepad1);

    }

    public void loop(){
        controller.readButtons();
        motorRight.setPower(controller.getLeftY()); // Assining buttons to actions//
        motorLeft.setPower(controller.getRightX()); // Assining buttons to actions//
        if(controller.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0){
            motorArm.setPower(0.2);
        //Says what happens when you click the button for the arm//

        } else{
            motorArm.setPower(-0.2);
            //Shows how to move the arm back up//
        }

        if(controller.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)>0){
            servoRight.setPosition(0.2);
            servoLeft.setPosition(0.2);



        }else{
            servoRight.setPosition(-0.2);
            servoLeft.setPosition(-0.2);
        }



    }

    public void stop(){
        motorRight.setPower(0);
        motorArm.setPower(0);
        motorLeft.setPower(0);
        //Fully Stops the Robot//
    }


}

