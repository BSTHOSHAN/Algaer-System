package subsystems.Algaer;
import com.ctre.phoenix6.hardware.TalonFX;


class AlgaerIOTalonFX implements AlgaerIO {
    private TalonFX talonFX;

    public AlgaerIOTalonFX(TalonFX talonFX) {
        this.talonFX = talonFX;
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