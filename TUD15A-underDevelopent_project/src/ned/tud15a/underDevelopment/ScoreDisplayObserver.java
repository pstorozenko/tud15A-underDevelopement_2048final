package ned.tud15a.underDevelopment;

public class ScoreDisplayObserver extends ScoreObserver {
	int score = 0;
	ScoreDisplay scoreDisplay;

	public ScoreDisplayObserver(ScoreInformer scoreInformer, ScoreDisplay scoreLab) {
		this.scoreInformer = scoreInformer;
		this.scoreInformer.attach(this);
		scoreDisplay = scoreLab;
	}

	@Override
	public void update() {
		score += scoreInformer.getState();
		scoreDisplay.updateScore(score);
	}
}
