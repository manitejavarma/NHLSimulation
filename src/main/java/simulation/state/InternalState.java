package simulation.state;

public class InternalState implements IHockeyState {

    private HockeyContext hockeyContext;
    private ISimulateState simulateState;

    public InternalState(HockeyContext hockeyContext){
        this.hockeyContext = hockeyContext;

    }

    @Override
    public void entry() {
        simulateState = new InitializeSeasonState();
        simulateState.action();
    }

    @Override
    public void process() {
        do{
            simulateState = simulateState.action();
        }while(simulateState!=null);
    }

    @Override
    public IHockeyState exit() {
        System.out.println("Exiting App!");
        return null;
    }
}