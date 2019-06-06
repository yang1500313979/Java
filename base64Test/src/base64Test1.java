import sun.misc.*;

import java.io.*;


public class base64Test1 {
    public static String fileToBase64(String path) {
        String base64 = null;
        InputStream in = null;
        try {
            File file = new File(path);
            in = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            in.read(bytes);
            base64 = new BASE64Encoder().encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return base64;
    }

    public static void base64ToFile(String base64, String fileName) {
        File file = null;
        //创建文件目录
        String filePath = "";
        File dir = new File(filePath);
        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdirs();
        }
        BufferedOutputStream bos = null;
        java.io.FileOutputStream fos = null;
        try {
            byte[] bytes = new BASE64Decoder().decodeBuffer(base64);
            file = new File(filePath + "" + fileName);
            fos = new java.io.FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
//       String aa =  fileToBase64("/Users/yoli/Desktop/youke.png");
//       System.out.println(aa);
       String aa = "iVBORw0KGgoAAAANSUhEUgAAAHgAAACvCAYAAAA2XxpFAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA3FpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDE0IDc5LjE1MTQ4MSwgMjAxMy8wMy8xMy0xMjowOToxNSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDo5NmUwOTNhOC00NDYwLTc3NDgtYWUyZS0zMDE5ZjQ4YTI4OTYiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QjU2Mzg4RTM2NDc1MTFFNjkzQ0M5QUU2NEEwQUVBNTIiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QjU2Mzg4RTI2NDc1MTFFNjkzQ0M5QUU2NEEwQUVBNTIiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChXaW5kb3dzKSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjE2NDliODJiLWE0YmEtMTI0Yy1hMjQ2LTkwZjhlMTNjMjNkOSIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo5NmUwOTNhOC00NDYwLTc3NDgtYWUyZS0zMDE5ZjQ4YTI4OTYiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz5ieWHCAAAZK0lEQVR42uxdCXQd1Xn+tdryIvsZ27KxHczzhvFC7AfUaVNCEzklgOO4jQwphJg0ldOmgTRJEU1Le1raHDtkg56msRoaSEgKqE1DoEHEMnXaQsBYrIkdm1hWjPdFkhfhTUvvx3yDrq5m3pu3zszT/Of8x7Le08yd+91//++dkjHbDkpIqUrxBMWTFU9VPEPxJMVTyOMVV5Px8wjFffzbUsVnFXcpPkHGzwfJRxS/ofiA4sOKOxSfDuIknJxfk/Tz8pCBOlHxbMWzyBcrnsbfjyGI4JGKK8h4xhKX62Fx9Cg+Tz5D4MGnFB9VvE9xu+JfaXwsLBMWdIBLCeIcxfMUL1Q8kxI7mRJclsX1S7SFABrn8J1exZ2KDyneT7B/oXiH4p38f18EsHcaQVULlbtY8VLFlyueT7VcaCqjhgAv4O+grrcrfkHxi4pfVbyXqv1sBLCzpEKtjlV8peL3kRcG2P4vJQsBfpq8BaaR6r4vAtgiqNqVin9X8bv4/8oQ+QaX0jf4sOKfKX5K8WO04cMa4OmKVyj+AKUVLuGoEHr05WSM/TqaFCzYJxU/TvU9rAB+h+LfVHyN4qvoSBULjeLzXMxF+xuKmxU/q3hPsQMco+O0SvH1DHWKmWyg3634CcX/SXvdWagBlBQo0VFBL/T3FK9VvEiGJ72meIPiH9A+ny+WREdC8e10osbK8CWEendTou9V/FzYVTTShB9TfKPiyxSPluFN5TRTK+iHPKz4QbFSpaEDGKHDLYpvECv7FNEAjaaTeaFYqdbvKN4WFoCRiVqi+E8Uf0TCl+8uJGHhf45Af0OsrNi5IAM8hivzLtqZiLxh8FHFFyn+eyZKTuXq4qU59pThRN3D2C+i9OhdnLv3y0DxIzASPIar8DOK50ZYZSwgyBF8UaxK2XcVdwcB4GqCizBoTgAnro8TheR/L3+HCtFIOjulARorypfzKCj4+XvZetjZAjyajlSQwAWYKNshW4SODGRyjnGidICxMC8Qq/tjKsOXSQEJ5eZxTnsJcrcfAI+hzb1DcdznCUFXBuqwaK9BznezWCnBPQT6bBKPP8aYFOrxajqJk/lZuc8g38HF+VSmjlemD1BBp+Cv6P35Ta9wEv5LrEL8GYLeK8lrsvaiwCQijfgfYmWbruPiTQQgjLqL2geL9nyhAEac+zdi5ZTLfJwA9Ev9m1i11zaq5P4MbHQfJ+80w5R2sUp9K2mCpvn0fJjbBRQkNAW+UAiAbfvwWz6v7p8qfkisUtzeFKHgaLJda36Tdq3bQcKxQPbLQP/VDjqRV/kYJ1/FOf87sfrA8gYwnJCPK17tI7BQV/+t+GsE2Ykmc6xTaV/tBj270IGWmg6q5z2U/CP8v05YON8Sq5Pys4rfQ+fMD7qBi+4ejjXnAMPu3sgb+eV8HKed/UtKl6nOqhiHf4AaZhZ9hBFJbPCvFe9S/AzV8k6q6l7te5u5EO6mfR7nkyRDsNCv/U2v9tgrUJi8pQR4uk/gYsJ/rPgLtL0mQVJRuVpFr76S407mI4zgIoAz89ucQBTlUeHZbXx3D++N+LTOp0U+nRigsW+rsQidgav81Oe9qmbo//dKDtNoadITlKCdht2spFb5C7HKcLM0cL0kMUr5XfxNDb3opbTFO7RJ7KMGeZ1awY+MXSnNTYzmqfsLk8ZkLcGjubKvSaLq8k0vi9UJ8arx+xqu6D+U3HWJ1FDFT+fCRs32kPY5xtBIkP3oTBlBLIDJt1MlQUo9rJgrFH/SJ+ein04VwH3a+GwiVfIdeZroRbz2LbyXTptoB09kEJblgqqJyRVjtx8qzQbgC2nTFoj7/p580llO5k+YvNDV8h8o/lOOMV+Ea3+asbDep/0mw7NN4s9OhhJisirV86cC+N0M9v0i2LxHxcon69781YrXFCgBgXvcynvq/sdBjq3Lx/n5oFip1YwAnkFd/w6fBn+GmZv/pcTYhOLAbVShhagElfJet/HeuhT/n1hdGGd8miNgc41S0zMyARiOxvt8Us2go4x5Dxu2ZyUTDoUMU8p5z5VGDHyYY+zwaY6AXy2x8gxwCZ2KFT7GvMJExiYjJEIIc5P4s8uwiveeZ8TmmxySLoUkSO8KJcUTFZd4AbiKun2xj4PuY7zbpsWhsH/vJPtR4CjjnCzWtEcvs2C/FH93Ei4mZlVeAK6m7Z3k44CPGeDazs5CH2Nxe/EvNjzXHo7Vz13/k4hZdSqAqxj3LhOrpcUvgm3b7eBQLPTRJ9DDE9PxRD77iI/jGknMEkpNj0wGcIxGu8bniYTTcsDB1swW/2mOA8D7fXS07IWHFObviHXgjCvAF9FzLvN5ElHO63RQQ5MDAHCNwzg6OGY/qYzCOdMN4DLGewsCADDKdWY3IWq5Qdj1XylDN9B1i//HLMHxw/6vy5SaLnMCGMgnJBh0zpgwjDNIO/9HGXMHgINy+MpSXYr1QcbpYAWBKgwnr1881D4LSL0yuMgwymfvXqcrROty1QFeYATxfhJKlOMMgN8MyNgQ754yAK4OkIYBhpeaAE8gwEEZ5BiOSacuyeGmrCzolAwtMIyT4Ox9BobzlR0epwM8V4LR36yHa1OM36F6sy8AYzvgEPPaOyOCQjgX5BIdYMSX0wI0QIREZh4czWY7AzA2tOyYp+XY3R9BoemM19/2TucwvgsKXUBboodr7ZKnXfBp0msyuLhQxrFeEKD5Q5w+C1mtUqqWmeJPK2iymG4ux1WqJRO2UD360SaDeyKF+rwM5J1LOca5EqyTDMZzXBPsLr2pEryjFuysWqUWmqC4jtbZHh/Gg3uiTecVGagcVXCMMwM2d+VU05MB8IUBUy+6Hb6eYyvRHBy7hae/wNJ7UAa3D+l180kBnD/M27RSIj0mgANE4gC138tkoBcKGS6cLYXzHwuZ+0XaFBvcsDHtrDa+BMcXxINTEbZNL+XqGxnAAdoVko/ShNiSBFt8n1j9UIUibGv5R97b1hwI427mGEsCOH/AdFIpBxpEgIWScQ1ZT8JgxwE2n/1PAcbwU95rp5FMwP7h90twUpROAE8pJ8BBHWQJPcI1YhXVm7XPWvgQCFMuz8MzQBWjq/Me3kunqzimcRJcwnzUQILDcPg2uhVuZbyu58+xXwm7D7DroUtyU5Do5bVwzT8Xq2tStLBoDseyLOBzBr8lVspVGIbT6FZwwk2PH1J2G9Xo7hzcp43XwjVbjc8mckFdH4L5AsDjy+lthQFg9Iutour8MlU2CPtksUF7A8GGXUTrykLx3rgAqf05pRbbZF6SwRvOQMjvfp5jCMOp9G9hi/OiEdfVSHgIIQv28N4v1q4Hk2YwdEGINdsO+MXqwijXkhYIs5CZ2ssF8jLZ6TgI7B3+I8UfknAdh3wAAHcF3FlwIzhcOF7hWRnaoKcnSwAysmIxzRGDFuikFgC4bh2RCM+w9+cT9OTDRl0A+JgMrb2GhVA+xB7ZRwjWack+jVlOc4BFgb3HH9fi8LBRR9gB7qPKfo22ExmuV7K85hI6dOhQRBNitQTruMO0AQ6rijadJPuFkvB8tzAZ8iuq4vPJQgmqcbS5XEmA7fpuWcjnpSuMTlYqsreS7JWB180dZWyr55HHM+yxmwvQzB4PsbQ6OlnlfPCg5lMztaFzZfAhKShSHJeB09QrqbUqpXgJOfPjmIxurvqKIn7YSglmSS/fmqy7lCu7RyIqNoLf0QWAOyTHL4KIKDAAd0JFH5SAvfM2B3SGMTH+RcP8KRl6jgYqUWh0GMWfqyS4ZdNMCJgesgE+E9KH6GUcfIrhEBzGA+Qu+hcn+Jl5YNhohkjV/Hk8ExpT+XOMC6A6pOESMD1YzjAiLAD3U/WcJ3DoUcbJcyjG/5Jx8AH6FZnQOAKMfPYl9MSxo38OgbZfB18SEoCPlDNW7A7RqkRPFlpXUTn6OQHtFW8nvKciWxsgjn6GkgvAUZnCpi68LmiZ+HMITLoETPcCYORzjwV8sMhK4TSbzZTUY1S7p/OgIXrJtuN5kpoBC+v7lOyrxWqXnRfgOcMc7QPAdsmsR4JVF4aTgD7oLZQmSGx7ir+xW1nRFDCWDlQ12UxqnKPEnqAjdpKTclSGtuSeJuOohtc4Fiw2nEmN9Cb25Aap7amHmB4uZ5jUTqdkYkCAhYrEqe5oyfmZuB8XCK93Ah0iZOOQbpxNG2qDHNPsZ7+2EM5rDpgNLiQV+es9XPidnB/TR2knbxTr5SQoTuCgtHhAPPEujq+jnIPfxQfyE+BeShKK+P9CcHscJLSC0ggAl3CC30nVOSkH9vE0HU+Ygpe5wF7iAjjHhdGvTSROiUdTHk6b+wTV9yifPW9guevk/JoztkreSZG+1MdBQXJQwP93Ok5O2bXRdHTQYfFegjqKoJfnyLuFBKL4MIUq+FaC/TQX3/MydJ8yQH+KHv2HxTq/+hIf53IvMRUd4HafBgOpwPuK/lWsWq5TdwU0CzoqllNaayit+aj8lJAryaOpLRAyraJUQzU3017rpgVz+CC/g7Os63yyze0mwFA126kiRxV4peG9Rw/J0NPchUBCYq+l1M73KQYt5VjAaAJAHzaOWv4xJVpv0DtClX2Qz3cTfYJCETDcptRzlxhe8y8YjiwpUMICdh+Nc40y9BCxasaeH6QD46fpcJLwS8lYdOgi+RFjcv3oJ/z/S3TUYJtnSWFqzcDw7X3UOsBtdP/zDXCP9vA/kMF5cPulkQD2UxKcU3/cyAYa/sA/EWj9JZgA9+ti9Wujn1rfSJcveoFYDgG4nXFnvgn26a/F2jxmFjmgytBwvlqCcaqdV4Jf8A8E8D7DnzlHVd7J71yZ57G8qN9ff61OP1fXlXQq8qFOAOrdjHHNY5GwmesuquQaCVeC39Y8cynRnTRBupe9l/H1RZKfU/R7mIS5X9nfN5wkGPRrhgPz8pDVQjPcV7mazdAH3ukfS4r3D4SAIBgr6eGD0aDfrUnyk5xX8LI8ALzRjIbKHTIgAPj3GQvmymPFTb9CG6UTslDYLfC5gDlS2RIW6niGWT80nMjHOe9flty9d9k+P+RpMQ5xNd981kMnYRFvXpGDGx+lQ9Ukg1N+yDhhAzVeFzdHio8m0SYfZ4SiJ272MVmSoAbLVpDO0Ox9W6nn42Z8Z9IJBvG5OOD6OONcvD3spKE5bqZDNUOKl2yn8WZDW57ign9IcvNaniPE7IRTAG/SaarSV3Nw42eomg/LQP62gnbqdhl6FlaxkX2G1u185gpDs90rzhvo0qVXidlpLwDbN39ckr942Us49A0ZfCoc7oeqS4P49zY1PxIjC/jM7zHmfC/j561ZXB8e8+NKNR9V3O8FYJvg8W2SzI4rgtr5voPHvCgkCYx80BV8dvM9iz/hXHVmcE10r7QQK0cqTbEymmXouYxebtrsAC5y3DfRax6u9CHOgZnvx3w9Iem3GwGbZj3uTQdgOzHxWJrgHmH8t8P47Abx9z2IQQL5RuN3r3PODqUJMuzus8m+kArg/bzxNo+qupdx3/NGWABHA28LnRXh+1b4ibeZ6pWxHiaCHhPvB8lsIzb7swEYqwnJ6286ueAOtI9hkX6uM1pR14hV9iuL8H1rDjAXH5PB23YPcO68OLbwcf4Z2Cj13JcNwCCk2h6hnUi2AwJxLroaXtSkF2EBaqcoHoyNsH2bMBfo/FiqhU7nOXfNkvxk+7N0qh4RD+3OXgsK6Ef6GtVIr0totZOBux6L4aBTpD2nRZgOoekE+UIjI/UQ/Zd+FxPYyvjZ04u4vAJsH+Vrql+bkEjfQoOv215UV66VcBzTVGgq59zo+5h7OI+bXaQY6vthYtGbS4BtFfIwVYPZEAc1g308+ospsCMA51XNiGyvqy3G3Fwtgw956aEkm0kg/P5RYnDe603Srfkiw3U/b2ReBx2ISMldoHnO10pxHYmQa8LcXE+PGoSOzlvEOgDG7K8GsN+SNGsEmajOHbQBKFwv06QT7v+nmZH5IZ2rRRGGKWkhnS20MaH1B00Psw3JRW/2fZLBS0kytY1oBP9bscqAizSQUSJrINjzI+n1LMVo3qtiMmi24fug1IgumJczuThO2cl0YLC5aLNZbyQw+mhDAPqICD9PdJqOqnlu6C4KzFNuoZOKg/MiwcIbNtPmflYGdtoF7UWSYaAqGbrlBqbwq5zj7mzUQzbUTeN/rwTjpVXFQjs5pw9Llnu3cxGfIoX5Hf78GSOuiygzcL/OOc16Y36uEhDdDJ+O0AucL8V97lY+CLHtdjpUP5IcnXyUSy/3HO0FTmV/LsIrbXqOc9csOTzWKtcpRDheeEsJCg/oc/6IRGnKVIQ4FylgVIeQgszpkVb5mPyzDMxhm/cztpsZ4ehI7WKlfr/LeDfnlE/pwoC/KFZxAh0Ml0lwXqLsN8FneYVe8oPirdYeOIBtDxtvDEPTwO1MjIwdxmrb3ljQzHnJu69SqIlGDfPPxKp/flKsNtLhSDtoa3FMRUchblgogBECICf6PbGS6thsdp0Mnx4tnD+CLlMUYZBT7izUjQutKvFgm8XaoAxHDOdu4DVxFxcpsLsZVTTzefcUegB+2cI9ZLTlYj8wjiBC2QyZ87DnsbHv+RA11ZNMWuzzazDZVJNySThFZyWdMJx7Zb9PMSzOWA+TEx2UVFR/0AJ7NN83zmc1KZfUwWAfL4JEowBafdDVsDgkAKNHGVtIsIVzKz3lQJzgGxQJ1mkEJRr9Sjj7YglBR347KKe8on67nWC+RMfpDUpsQQ9XD4sE63SWNgu8hQ4YNojb51+gWwRtuJOpyvPdNdJHDXOYY2qjxKLq8zodqb6gqpag2zhM3C5yMwGdQ55F8AE2mg7GUPrBaFizD+9OdsRhP+2nfcj4GS4wMPLqxwjqbo7hdXKHhITCllHCxD5PriLgkGT7lHb0hE0h44wMbA0ZzX9HyeDTZuHt4gSCbv7bxVgdbL9F7QAlt0NyfzZ1YWxwf3+/RFS8FHU9RgBHFAEcUQRwRBHAEUUARxQBHFEEcARwRBHAEUUARxQBHFEEcEQRwBFFAEcARxQBHFEEcEQRwBFFAEcUARyRR/K9bfaBBx5w+yihMfYXNya5DE6DWydWU7r93ZY8D72WYxPeM6P7rVmzpvgkWIEaU9zgYQI3KK4nJyN7ouP8u7YCPIa9qMB1kYrWwBXrLZnr1M/4N+by1SYDQLcXOcaMCV5fIICbjMUYAUyq1ySulmAnHL5nq1ub3KRE/31nClUuSRZJbZpA6QDHXZ4hmXaKFSXAyuasN0BIEGQnAFs8SIn+d42S2fEI9hjA/R7Z3J+0NY2/3ZjmggiXk6VAXqvUcyttrC1BDYZU2FISoyQ3OVwqbgBvawRdC7RpIOJadxqaIfKi8wRyIz3oDZpqbXBR1THD0bKBqnNxtlKp41S0PE+PvdFFOxVnmESQdQlbl8af32ksiFYP6tmr3Wtx8Zrr+VljBlogPqwk2GEy07VJ9RpgnZS6TI8nSgV8ggDbmqSW92vLAuCYFOA4Jb/i4LiLV4pJm6WBjn9LXLjBkOZsJiueAvwN2iLAOC9PA9yEy+ItiJPlRxwMCdjlkOhoI6BtHqU3rv1dY5bDWm8sHh1c0+Otowft1WPeSok3F2vx2WAFqm5nkejAZK3NwJ41GOD0Gx6zuIRX6bxxPJajcKaFYxwWXnTcQU1tpYpNZxJWc/Jt73sDr50rRybBa5rgNrqEa6Z2qdMcv9V+OjgFP8KBqcoGh5BoraZqN6bIKtk211br5rXsz9ZpIOF3Ezyq/3WazW01bGYjx+pEG7Rwznb8WlNEEsUFsAY0AHyUE9lixJ67Ukjj8hQ2LM5rJzTHaK0HR6xeS77Y4C7XFp1ePdJNS4z3q3X53DeAfasHqwdroTfa4qDG4poUtJC92ul6qv2EJu2rPXrZjdp3G7XQy5bGJsO02BK7SwO3xYvkFq2KdpBkp1/3G5NlO0sbU0iwPfH24lidobeaLEZdJ84ZN9vhuzPNhV6cEuyROjMARlevLTm+b6oqUNwI4Xyncp+lt0GSV4D8VnN2GTFBzzjuoNL1gked5kG3aaalrVBxb2AA1mLiBqq2dGPFjSkkOOHwnTidHzf1HpOB5gK3DJSdWNEXZpzPUaeNIS7OnSgthqZYXawSXKuBknBJTLR5vEYy6UtFWz0kM9roYDW5aJU2Lpy1BLnWANttzHcWrQQb6q7VRQqT2eBWF1AThqSlcp6W0wuOJclCpaNem7SwLEFAGxyera0QGS4/Aa5zASvuos6ckh1O0rExzQnsJBjrNMfMTp7US+76rUo01R+XAr2YwxeAaX9jLkDWukhoPqsvTTI0BZmPxr02KUxDoO9hUq0LuDEjYZCOes4n3SnuZctk7Dv5BXCdC8B1HkHslIiCCTCL/QkXIBsMrzWiEEqw2cfcooEb1xII6YREEQXIyap3UM96I4Cd6Nc7KeuM8MePMddGAKdWz7UOYZCZcVpv2Fiz03K94ZRt0EDP1x6hXDYTFLUEt8pAu2uMdraegMYckhPrZSB538a/bTJUfKs4t9vmMvfrpZPDiTb6DbAv5UJ2ddRjG4tWLnQLj2o1IJ0I1+pwkPL1WXrbDdqYmiSzxr5+I9ExhIq2o0MDOxeXadAkuilMYVS+Af5/AQYA+N9VqtNF2q4AAAAASUVORK5CYII=";


       base64ToFile(aa,"/Users/yoli/Desktop/youke4.png");

    }
}
