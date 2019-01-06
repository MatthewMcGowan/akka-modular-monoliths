using System;
using Akka.Actor;
using UserService;
using UserService.Model;

namespace Cli
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create system which will run our actors
            var actorSystem = ActorSystem.Create("AkkaMonolithShop");

            // Create "UserService" actor
            var userActor = actorSystem.ActorOf(Props.Create(() => new UserServiceActor()));

            // Immutable object to send
            var getUserRequest = new GetUserById(1);

            // Ask returns a Task
            var user = userActor.Ask<User>(getUserRequest).Result;

            Console.WriteLine(user.Email);
        }
    }
}
