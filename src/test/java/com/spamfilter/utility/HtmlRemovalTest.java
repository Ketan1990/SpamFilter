package com.spamfilter.utility;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ketan on 7/22/2014.
 */
public class HtmlRemovalTest {
    @Test
    public void itShulaRemoveHtmlContent()   {
        String maildata="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title>\n" +
                "having National frequently would view</title>\n" +
                "</head>\n" +
                "<body link=\"#003366\" alink=\"#003366\" vlink=\"#003366\">\n" +
                "<div align=\"center\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"728\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td align=\"center\" width=\"730\">\n" +
                "<div style=\"padding: 5px; font-family: Arial,Helvetica,sans-serif; font-size: 11px; margin-top: 10px; background-color: rgb(239, 239, 239); color: rgb(102, 102, 102); margin-bottom: 3px;\">\n" +
                "To view this email as a web page, <a href=\"http://f5.pharmlalo.ru/?seufyenow=d87b2b17dd\">click here.</a>\n" +
                "</div>\n" +
                "<table bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"0\" width=\"730\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td align=\"left\" valign=\"top\" width=\"420\">\n" +
                "<div style=\"font-size: 13px; font-family: arial,helvetica,sans-serif;\">\n" +
                "<div style=\"color: rgb(51, 51, 51); font-size: 16px; font-weight: 700;\">\n" +
                "Thu, April 15, 2010</div>\n" +
                "</div>\n" +
                "</td>\n" +
                "<td width=\"10\">&nbsp;</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"730\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div style=\"font-family: Arial,Helvetica,sans-serif; font-size: 12px;\" align=\"center\">\n" +
                "<br />\n" +
                "<a href=\"http://a9e.pharmlalo.ru/?nuohadi=4e4754523e0\">\n" +
                "<img alt=\"eStore's direct link\" height=\"456\" src=\"http://img9.imageshost.ru/imgs/100404/321b297577/6f685.jpg\" style=\"border-width: 0px\" width=\"551\" /></a><br />\n" +
                "<br />\n" +
                "<br />\n" +
                "<a href=\"http://51fb.pharmlalo.ru/?yucit=3a1c68ea8b0f80\" style=\"text-decoration: none;\">and</a> |\n" +
                "<a href=\"http://33.pharmlalo.ru/?eiukoyh=3232673313894\" style=\"text-decoration: none;\">sources</a> |\n" +
                "<a href=\"http://1b5f.pharmlalo.ru/?ajewazovoz=018ca16ce05\" style=\"text-decoration: none;\">performances</a> |\n" +
                "<a href=\"http://d271.pharmlalo.ru/?okokaw=b01fa52f721c\" style=\"text-decoration: none;\">Jr Gloag</a><br />\n" +
                "<a href=\"http://49.pharmlalo.ru/?yfawa=913b15687e\" style=\"text-decoration: none;\">Paul were nor</a> |\n" +
                "<a href=\"http://10c.pharmlalo.ru/?vezyhajyvy=310955230d\" style=\"text-decoration: none;\">September crisis</a>\n" +
                "</div>\n" +
                "<div style=\"font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: left;\">\n" +
                "<br />\n" +
                "A landslide causes a train to derail in Merano, Italy, killing nine people and injuring \n" +
                "dozens.\n" +
                ">From the time of European <p align=\"left\">settlement, a</p> theme in Australian <h2>art \n" +
                "has been <p>the <p align=\"left\">Australian</p> landscape, [186] seen</p> \n" +
                "for</h2> \n" +
                "<p>example in the works <p align=\"right\">of Albert</p> Namatjira, [187] Arthur Streeton and</p> others associated with the Heidelberg School, [186] and <h5>Arthur</h5> Boyd.Issues of intergenerational <p align=\"right\">equity, irreversibility</p> of \n" +
                "environmental change, uncertainty of long-term \n" +
                "outcomes, and sustainable \n" +
                "development guide ecological economic analysis and valuation.\n" +
                "Lake <div>Issyk-Kul in the <h2>north-eastern Tian Shan is the</h2> largest</div> lake in Kyrgyzstan and the second largest mountain \n" +
                "lake in the world after Titicaca.\n" +
                "The fifth and final category is the importance of \n" +
                "caring for oneself, since only thus can one <h2>act</h2> to help others.\n" +
                "Given the <p align=\"center\">poor precision for asteroids</p> <p align=\"left\">estimated \n" +
                "to be</p> somewhat less massive than 16 Psyche, <center>a \n" +
                "few other</center> may turn out <b>to</b> be more massive \n" +
                "than Psyche, 3 <p align=\"center\">Juno, or</p> 15 <p align=\"right\">Eunomia.\n" +
                "The marsh</p> rice \n" +
                "rat is active during the night and builds <br>nests of \n" +
                "sedge and grass and occasionally runways.Loss \n" +
                "ratio \n" +
                "is calculated \n" +
                "by dividing the amount <p align=\"center\">of</p> losses <p align=\"right\">(sometimes</p> including loss adjustment expenses) by the amount of earned premium.\n" +
                "These are placed at <br>various intervals along the \n" +
                "route of a \n" +
                "railway, controlling specified \n" +
                "sections of <p align=\"right\">track.\n" +
                "Fisher Z, Hernandez Prada JA, Tu</p> \n" +
                "C, Duda \n" +
                "D, <h5>Yoshioka C, \n" +
                "An</h5> H, Govindasamy L, Silverman DN \n" +
                "and McKenna R.\n" +
                "Presidents <p>of \n" +
                "Poland</p> and non-presidential heads of state since 1918.\n" +
                "Grace and he disliked each <p align=\"left\">other</p> for the rest of the season, until the season finale when Ben showed <h2>her</h2> his more humane face when Will invited him to dine with them.Anelli, Melissa, \n" +
                "John Noe, Sue Upton.\n" +
                "In <b>April 2007,</b> the <p align=\"right\">government of Morocco suggested that \n" +
                "a self-governing entity,</p> through <h5>the</h5> Royal Advisory Council for Saharan Affairs (CORCAS), should govern the territory with some degree of autonomy for Western Sahara.\n" +
                "Hansen TM, Baranov PV, Ivanov IP, Gesteland RF, \n" +
                "Atkins JF (May 2003).\n" +
                "On <p align=\"left\">1</p> January 1901, the six colonies \n" +
                "became a \n" +
                "federation and the \n" +
                "Commonwealth of Australia was formed.The Space <p align=\"center\">Shuttle program \n" +
                "will</p> be retired by NASA.\n" +
                "The first \n" +
                "few asteroids discovered were assigned symbols <b>like the ones</b> traditionally used to designate Earth, the Moon, \n" +
                "the Sun and planets.\n" +
                "In 1985-90 Chalidze was \n" +
                "a MacArthur Fellow for his work in international human rights.\n" +
                "The highest judicial body \n" +
                "is the Supreme Tribunal of Justice <br>or Tribunal Supremo de Justicia, whose \n" +
                "magistrates are <div>elected</div> by \n" +
                "parliament for a single twelve-year term.\n" +
                "The university is home to 16 colleges, <em>a graduate school, 93 undergraduate programs,</em> 99 master programs, 66 <em>doctoral</em> programs, and four professional programs.\n" +
                "Victoria \n" +
                "County History \n" +
                "of Wiltshire, Volume 3.Several \n" +
                "phenomena will prefigure the changes <br>of the upcoming period.\n" +
                "As of 2009, Hong Kong is the \n" +
                "fifth \n" +
                "most \n" +
                "expensive city for expatriates, behind Tokyo, Osaka, Moscow, \n" +
                "and Geneva.\n" +
                "He was \n" +
                "born at <h2>Semley, \n" +
                "Wiltshire,</h2> in <p>1568 or 1569, \n" +
                "entered Winchester \n" +
                "College in 1582.\n" +
                "Astronomers</p> began to <h5>realize \n" +
                "the</h5> possibilities of Earth impact.Examples are 3753 Cruithne and 2002 AA <h2>29.Metre</h2> (7ft) diameter Beumont-English boring machine dug a 1,893-metre (6,211ft) pilot tunnel from Shakespeare Cliff.\n" +
                "Earlier attempts at designing such an engine failed because \n" +
                "of the difficulty in arranging the pistons to move in the correct manner, for all three cylinders in one delta, \n" +
                "and \n" +
                "this was the problem which caused Junkers Motorenbau to leave <h5>behind</h5> work on the delta-form while continuing to prototype \n" +
                "of a diamond-form four-crankshaft 24-cylinder JuMo 223.For other uses, <p align=\"right\">see</p> Kelvin <strong>(disambiguation).\n" +
                "Soon</strong> thereafter, mammals entered <p align=\"right\">India</p> from Asia through two zoogeographical passes on either \n" +
                "side of the emerging Himalaya.\n" +
                "Today there is a Turkish town called Truva in the vicinity of the archaeological site, but \n" +
                "this town has grown up recently to service the tourist trade.\n" +
                "Close to the <br>centre of \n" +
                "the city lay a large \n" +
                "temple to Bast.\n" +
                "<br />\n" +
                "<br />\n" +
                "You are subscribed as: hibody@csmining.org.<br />\n" +
                "<a href=\"http://ff12.pharmlalo.ru/?aijoo=58abed15c0069\" style=\"text-decoration: none;\">\n" +
                "Click here to unsubscribe.</a>\n" +
                "<br />\n" +
                "<br />\n" +
                "Copyright (c) 2010 beam<br />\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n";
        String actual= HtmlRemover.removeAllHtml(maildata);
        String expected="having National frequently would view To view this email as a web page, click here. Thu, April 15, 2010   and | sources | performances | Jr Gloag Paul were nor | September crisis A landslide causes a train to derail in Merano, Italy, killing nine people and injuring dozens. >From the time of European settlement, a theme in Australian art has been the Australian landscape, [186] seen for example in the works of Albert Namatjira, [187] Arthur Streeton and others associated with the Heidelberg School, [186] and Arthur Boyd.Issues of intergenerational equity, irreversibility of environmental change, uncertainty of long-term outcomes, and sustainable development guide ecological economic analysis and valuation. Lake Issyk-Kul in the north-eastern Tian Shan is the largest lake in Kyrgyzstan and the second largest mountain lake in the world after Titicaca. The fifth and final category is the importance of caring for oneself, since only thus can one act to help others. Given the poor precision for asteroids estimated to be somewhat less massive than 16 Psyche, a few other may turn out to be more massive than Psyche, 3 Juno, or 15 Eunomia. The marsh rice rat is active during the night and builds nests of sedge and grass and occasionally runways.Loss ratio is calculated by dividing the amount of losses (sometimes including loss adjustment expenses) by the amount of earned premium. These are placed at various intervals along the route of a railway, controlling specified sections of track. Fisher Z, Hernandez Prada JA, Tu C, Duda D, Yoshioka C, An H, Govindasamy L, Silverman DN and McKenna R. Presidents of Poland and non-presidential heads of state since 1918. Grace and he disliked each other for the rest of the season, until the season finale when Ben showed her his more humane face when Will invited him to dine with them.Anelli, Melissa, John Noe, Sue Upton. In April 2007, the government of Morocco suggested that a self-governing entity, through the Royal Advisory Council for Saharan Affairs (CORCAS), should govern the territory with some degree of autonomy for Western Sahara. Hansen TM, Baranov PV, Ivanov IP, Gesteland RF, Atkins JF (May 2003). On 1 January 1901, the six colonies became a federation and the Commonwealth of Australia was formed.The Space Shuttle program will be retired by NASA. The first few asteroids discovered were assigned symbols like the ones traditionally used to designate Earth, the Moon, the Sun and planets. In 1985-90 Chalidze was a MacArthur Fellow for his work in international human rights. The highest judicial body is the Supreme Tribunal of Justice or Tribunal Supremo de Justicia, whose magistrates are elected by parliament for a single twelve-year term. The university is home to 16 colleges, a graduate school, 93 undergraduate programs, 99 master programs, 66 doctoral programs, and four professional programs. Victoria County History of Wiltshire, Volume 3.Several phenomena will prefigure the changes of the upcoming period. As of 2009, Hong Kong is the fifth most expensive city for expatriates, behind Tokyo, Osaka, Moscow, and Geneva. He was born at Semley, Wiltshire, in 1568 or 1569, entered Winchester College in 1582. Astronomers began to realize the possibilities of Earth impact.Examples are 3753 Cruithne and 2002 AA 29.Metre (7ft) diameter Beumont-English boring machine dug a 1,893-metre (6,211ft) pilot tunnel from Shakespeare Cliff. Earlier attempts at designing such an engine failed because of the difficulty in arranging the pistons to move in the correct manner, for all three cylinders in one delta, and this was the problem which caused Junkers Motorenbau to leave behind work on the delta-form while continuing to prototype of a diamond-form four-crankshaft 24-cylinder JuMo 223.For other uses, see Kelvin (disambiguation). Soon thereafter, mammals entered India from Asia through two zoogeographical passes on either side of the emerging Himalaya. Today there is a Turkish town called Truva in the vicinity of the archaeological site, but this town has grown up recently to service the tourist trade. Close to the centre of the city lay a large temple to Bast. You are subscribed as: hibody@csmining.org. Click here to unsubscribe. Copyright (c) 2010 beam";
        System.out.println(actual);
        assertEquals(expected, actual);


    }
}