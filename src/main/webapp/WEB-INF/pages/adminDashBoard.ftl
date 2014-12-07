[#ftl]
<html lang="en">
<head>
    <title>Weather</title>
    <meta charset="utf-8">
    <title> Weather - Admin Dashboard </title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="../resources/images/icon.jpg">
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,300italic,400italic' rel='stylesheet'
          type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../resources/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/plugins/font-awesome/css/font-awesome.css">
    <link id="theme-style" rel="stylesheet" href="../resources/css/styles.css">
</head>

<body data-spy="scroll" data-offset="0" data-target="#navbar-main">
<div id="navbar-main">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="../j_spring_security_logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </div>
    <br>
</div>

<header class="header">
    <div class="container">
        <div class="row">
        [#if weatherJsonObjectWrapper.dataJsonObject.currentConditionJsonObjects??]
            [#list weatherJsonObjectWrapper.dataJsonObject.currentConditionJsonObjects as currentConditionJsonObject]
                <div class="col-lg-6">
                    <img class="profile-image img-rounded pull-left"
                         src="${currentConditionJsonObject.weatherIconUrlJsonObjects[0].weatherImageUrl}"
                         alt="Weather Image"/>

                    <div class="profile-content">
                        <h4 class="desc"><b>${currentConditionJsonObject.degreeInCelsius}°c</b></h4>

                        <h2><b>${currentConditionJsonObject.weatherDescriptionJsonObjects[0].weatherDescription}</b>
                        </h2>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="profile-content">
                        <h4 class="desc"><b>Wind:</b>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${currentConditionJsonObject.windSpeedKmPerHour}
                            km/h</h4>
                        <h4 class="desc"><b>Humidity:</b> &nbsp;&nbsp;${currentConditionJsonObject.humidityPercentage} %
                        </h4>
                        <h4 class="desc"><b>Real Feal:</b> &nbsp;&nbsp;${currentConditionJsonObject.realFeelInCelsius}°c
                        </h4>
                    </div>
                </div>
            [/#list]
        [/#if]

        [#if weatherJsonObjectWrapper.systemNote.userEmail??]
            <h2>${weatherJsonObjectWrapper.systemNote.text}</h2>
        [#else]
            <button type="button" class="btn btn-primary" data-toggle="modal"
                    data-target="#setTodayNote">
                Set Today's Note
            </button>
        [/#if]

            <button type="button" class="btn btn-primary" data-toggle="modal"
                    data-target="#oldSystemNotesModal">
                Show System Notes History
            </button>
        </div>
    </div>
</header>

<div class="container sections-wrapper">
    <div class="row">
    [#if weatherJsonObjectWrapper.dataJsonObject.weatherForecastJsonObjects??]
        [#list weatherJsonObjectWrapper.dataJsonObject.weatherForecastJsonObjects as weatherForecastJsonObject]
            <div class="primary col-md-6 col-sm-12 col-xs-12">
                <section class="about section">
                    <div class="section-inner">
                        <h2 class="heading">${weatherForecastJsonObject.date}</h2>

                        <div class="content">
                            <img class="profile-image img-rounded"
                                 src="${weatherForecastJsonObject.hourlyJsonObjects[0].weatherIconUrlJsonObjects[0].weatherImageUrl}"
                                 alt="Weather Image"/>

                            <h2 class="desc">${weatherForecastJsonObject.hourlyJsonObjects[0].weatherDescriptionJsonObjects[0].weatherDescription}</h2></br>

                            <h4>Max:
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weatherForecastJsonObject.maxTemperatureInCelsius}
                                °c</h4>
                            <h4>Min:
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weatherForecastJsonObject.minTemperatureInCelsius}
                                °c</h4>
                            <h4>Wind:
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${weatherForecastJsonObject.hourlyJsonObjects[0].windSpeedKmPerHour}
                                km/h</h4>
                            <h4>Humidity:
                                &nbsp;&nbsp;${weatherForecastJsonObject.hourlyJsonObjects[0].humidityPercentage}
                                %</h4>
                        </div>
                    </div>
                </section>
            </div>
        [/#list]
    [/#if]
    </div>
</div>

<div class="modal fade" id="oldSystemNotesModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span
                        aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">System Notes History</h4>
            </div>
        [#if oldSystemNotes?has_content]
            [#list oldSystemNotes as systemNote]
                <div class="modal-body">
                    <div class="col-md-18">
                    ${systemNote.date} - ${systemNote.text}
                    </div>
                </div>
            [/#list]
        [#else]
            No History Found For System Notes
        [/#if]
        </div>
    </div>
</div>

<!-- Add Today's Note -->
<div class="modal fade" id="setTodayNote" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <form action="updateSystemNote" method="POST" autocomplete="on">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">Set Today's Note</h4>
                </div>
                <div class="modal-body">
                    <div class="col-md-18">
                        <textarea class="form-control input-xlarge" id="systemNote" name="systemNote"
                                  rows="6"> Set Today's Note </textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </form>
</div>

<script type="text/javascript" src="../resources/plugins/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../resources/plugins/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="../resources/plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../resources/plugins/jquery-rss/dist/jquery.rss.min.js"></script>

</body>
</html>