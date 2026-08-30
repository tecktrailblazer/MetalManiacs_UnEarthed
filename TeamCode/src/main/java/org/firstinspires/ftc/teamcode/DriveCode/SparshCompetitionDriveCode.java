package org.firstinspires.ftc.teamcode.DriveCode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.DcMotor;

public class SparshCompetitionDriveCode {

    DcMotor motorRight;
    DcMotor motorLeft;
    DcMotor motorArm;

    GamepadEx controller;

    public void init(){
        motorRight = hardwareMap.get(DcMotor.class,"motorRight");
        motorLeft = hardwareMap.get(DcMotor.class,"motorLeft");
        motorArm = hardwareMap.get(DcMotor.class,"motorArm");
        controller = new GamepadEx(gamepad1);

    }

    public void loop(){
        controller.readButtons();
        motorRight.setPower(controller.getLeftY());
        motorLeft.setPower(controller.getRightX());
        if(controller.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0){
            motorArm.setPower(1);

        } else{
            motorArm.setPower(-1);
        }



    }

    public void stop(){
        motorRight.setPower(0);
        motorArm.setPower(0);
        motorLeft.setPower(0);

    }


}

