var BASE_URI="http://localhost:8080/dsaApp/"

function myfunction(){

    $.ajax({
    type: 'GET',
    url: BASE_URI.concat("usermanager/getObjetos/" + window.localStorage.getItem("username")+),
    dataType:'json',
    success: function(data){
    console.log(data);
        for(let i=0; i<data.length; i++)
            {
                $("table").append(
                <tr>
                <td>$(data[i].Nombre)</td>
                <td>$(data[i].Coste)</td>
                </tr>);
            }
          }
        });
     }