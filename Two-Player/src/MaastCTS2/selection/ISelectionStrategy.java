package MaastCTS2.selection;

import MaastCTS2.model.MctNode;
import MaastCTS2.test.IPrintableConfig;
import core.game.StateObservationMulti;
import tools.ElapsedCpuTimer;

public interface ISelectionStrategy extends IPrintableConfig {
	public MctNode select(MctNode rootNode, ElapsedCpuTimer timer);

	/**
	 * optional method that is called when the agent is initialized.
	 * 
	 * @param so
	 * @param elapsedTimer
	 */
	public void init(StateObservationMulti so, ElapsedCpuTimer elapsedTimer);
	
	/**
	 * Should be implemented to return the maximum desired size of n-grams of actions
	 * to collect statistics for.
	 * 
	 * <p> If a value < 1 is returned, will not collect statistics for any n-grams
	 * 
	 * @return
	 */
	public int getDesiredActionNGramSize();
	
	/**
	 * Should be implemented to return true iff the selection strategy requires
	 * action statistics to be backpropagated (for example, Progressive History)
	 * 
	 * @return
	 */
	public boolean wantsActionStatistics();
}
