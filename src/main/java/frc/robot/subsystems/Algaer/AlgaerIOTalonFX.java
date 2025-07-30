package frc.robot.subsystems.Algaer;
import com.ctre.phoenix6.hardware.TalonFX;


class AlgaerIOTalonFX implements AlgaerIO {
    private TalonFX talonFX;

    public AlgaerIOTalonFX() {
        talonFX = new TalonFX(0);
    }

    @Override
    public void setSpeed(double speed) {
        talonFX.setVoltage(speed);
    }

    @Override
    public void setPivotAngle(double position) {
        talonFX.setPosition(position);
    }

    @Override
    public boolean getGamePiece() {
        return true;
    }
}