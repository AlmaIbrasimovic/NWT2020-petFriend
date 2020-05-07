package com.example.systemevents;
import com.example.systemevents.PetFriend.Request;
import com.example.systemevents.PetFriend.Response;
import io.grpc.stub.StreamObserver;

public class SystemEventsService extends SystemEventsGrpc.SystemEventsImplBase {
    @Override
    public void logAction(Request request, StreamObserver<Response> responseObserver) {
        String Odgovor = new StringBuilder()
                .append("Servis, ")
                .append("Vrijeme " + request.getTimeStampAkcije() + "")
                .append(request.getNazivMikroservisa())
                .append(request.getAkcija())
                .append(request.getNazivResursa())
                .toString();

        Response response = Response.newBuilder()
                .setPorukaOdgovora(Odgovor)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
