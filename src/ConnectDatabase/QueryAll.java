package ConnectDatabase;

public class QueryAll {
    Connector connector;
    public QueryCustomer queryCustomer;
    public QueryEmployee queryEmployee;
    public QueryRoom queryRoom;
    public QueryService queryService;
    public QueryCustomerRoom queryCustomerRoom;
    public QueryRoomService queryRoomService;

    public QueryAll(Connector connector) {
        this.connector = connector;
        this.queryCustomer = new QueryCustomer(connector);
        this.queryEmployee = new QueryEmployee(connector);
        this.queryRoom = new QueryRoom(connector);
        this.queryService = new QueryService(connector);
        this.queryCustomerRoom = new QueryCustomerRoom(connector);
        this.queryRoomService = new QueryRoomService(connector);
    }
}
