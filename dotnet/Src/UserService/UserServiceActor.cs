using System;
using System.Linq;
using Akka.Actor;
using UserService.Model;

namespace UserService
{
    public class UserServiceActor : ReceiveActor
    {
        public UserServiceActor()
        {
            Receive<GetUserById>(msg => {
                var user = FakeDb.Users.First(u => u.Id == msg.Id);
                Sender.Tell(user);
            });
        }
    }
}
