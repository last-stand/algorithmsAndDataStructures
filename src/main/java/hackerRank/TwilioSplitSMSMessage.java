package hackerRank;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* https://www.hackerrank.com/challenges/sms-splitting/problem
* */
public class TwilioSplitSMSMessage {
    private static final int MAX_SEGEMENT_SIZE = 160;

    public static List<String> getMessageSegments(String message) {
        int messageLength = message.length();
        List<String> segmentList = new ArrayList<>();
        if (messageLength <= MAX_SEGEMENT_SIZE) {
            segmentList.add(message);
            return segmentList;
        }
        int segmentLength = 154;
        int startSegmentPosition = 0;
        int endSegmentPosition = segmentLength;
        while(endSegmentPosition < messageLength) {
            if(message.charAt(endSegmentPosition) != ' ') {
                while (endSegmentPosition >= startSegmentPosition &&
                        message.charAt(endSegmentPosition) != ' ' &&
                        message.charAt(endSegmentPosition + 1) != ' ') {
                    endSegmentPosition--;
                }
            }
            segmentList.add(message.substring(startSegmentPosition, endSegmentPosition + 1));
            startSegmentPosition = endSegmentPosition + 1;
            endSegmentPosition = startSegmentPosition + segmentLength;
        }
        segmentList.add( message.substring(startSegmentPosition, messageLength));

        int segmentCount = segmentList.size();
        AtomicInteger counter = new AtomicInteger();
        segmentList = segmentList.stream().map(
                string -> string + "(" + counter.incrementAndGet() + "/" + segmentCount + ")"
        ).collect(Collectors.toList());

        return segmentList;
    }

    public static void main(String[] args) throws IOException {
        String message = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver rup. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.";
        List<String> resultSegments = getMessageSegments(message);
        System.out.println(resultSegments.toString());

        String message2 = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus";
        List<String> resultSegments2 = getMessageSegments(message2);
        System.out.println(resultSegments2.toString());

        /*
        * Expected Output message1:
          Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu (1/3)
          sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver (2/3)
          rup. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.(3/3)
        *
        * Expected Output message2:
          Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis (1/5)
          parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede(2/5)
          justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede (3/5)
          mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, (4/5)
          consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus(5/5)
        * */
    }
}