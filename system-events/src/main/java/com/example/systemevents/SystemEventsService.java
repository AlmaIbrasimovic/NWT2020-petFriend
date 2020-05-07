package com.example.systemevents;
import com.example.systemevents.PetFriend.Request;
import com.example.systemevents.PetFriend.Response;
import io.grpc.stub.StreamObserver;
import org.apache.ibatis.mapping.Environment;

public class SystemEventsService extends SystemEventsGrpc.SystemEventsImplBase {

    @Override
    public void logAction(Request request, StreamObserver<Response> responseObserver) {
        StringBuilder Odgovor = new StringBuilder()
                .append("Vrijeme:" + request.getTimeStampAkcije())
                .append("Naziv mikroservisa: " + request.getNazivMikroservisa())
                .append("\n")
                .append("Tip akcije: " + request.getAkcija())
                .append("\n")
                .append("Naziv resursa: " + request.getNazivResursa())
                .append("\n");

        Response response = Response.newBuilder()
                .setPorukaOdgovora(Odgovor.toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
