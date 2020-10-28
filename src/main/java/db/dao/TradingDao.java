package db.dao;

import db.data.ITradingFactory;
import simulation.model.Trading;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TradingDao implements ITradingFactory {

    @Override
    public int addTradingDetails(Trading trading) throws Exception {
        ICallDB callDB = null;
        try{
            callDB = new CallDB("AddTrading(?,?,?,?,?,?)");
            callDB.setInputParameterInt(1, trading.getLeagueId());
            callDB.setInputParameterInt(2, trading.getLossPoint());
            callDB.setInputParameterInt(3, trading.getMaxPlayersPerTrade());
            callDB.setInputParameterDouble(4, trading.getRandomAcceptanceChance());
            callDB.setInputParameterDouble(5, trading.getRandomTradeOfferChance());
            callDB.setOutputParameterInt(6);
            callDB.execute();
            trading.setId(callDB.returnOutputParameterInt(6));

        } catch (SQLException sqlException){
            throw sqlException;
        } finally {
            callDB.closeConnection();
        }
        return trading.getId();
    }

    @Override
    public void loadTradingDetailsByTradingId(int tradingId, Trading trading) throws Exception {
        ICallDB callDB = null;
        try {
            callDB = new CallDB("LoadTradingDetailsByTradingId(?)");
            callDB.setInputParameterInt(1, tradingId);
            ResultSet rs = callDB.executeLoad();
            if (rs != null) {
                trading = new Trading();
                while (rs.next()) {
                    trading.setId(rs.getInt(1));
                    trading.setLeagueId(rs.getInt(2));
                    trading.setLossPoint(rs.getInt(3));
                    trading.setRandomTradeOfferChance(rs.getDouble(4));
                    trading.setMaxPlayersPerTrade(rs.getInt(5));
                    trading.setRandomAcceptanceChance(rs.getInt(6));
                }
            }
        }catch (Exception e){
            throw e;
        } finally {
            callDB.closeConnection();
        }
    }

    @Override
    public Trading loadTradingDetailsByLeagueId(int leagueId) throws Exception {
        ICallDB callDB = null;
        Trading trading = null;
        try{
            callDB = new CallDB("LoadTradingDetailsByLeagueId(?)");
            callDB.setInputParameterInt(1, leagueId);
            ResultSet rs = callDB.executeLoad();
            if (rs != null) {
                trading = new Trading();
                while (rs.next()) {
                    trading.setId(rs.getInt(1));
                    trading.setLeagueId(rs.getInt(2));
                    trading.setLossPoint(rs.getInt(3));
                    trading.setRandomTradeOfferChance(rs.getDouble(4));
                    trading.setMaxPlayersPerTrade(rs.getInt(5));
                    trading.setRandomAcceptanceChance(rs.getInt(6));
                }
            }
        } catch (Exception e){
            throw e;
        }
        return trading;
    }

}
