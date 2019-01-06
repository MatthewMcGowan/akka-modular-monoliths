using System;
using NUnit.Framework;
using Akka;
using Akka.TestKit.NUnit;
using Akka.Actor;
using UserService.Model;

namespace UserService.Test
{
    public class UserServiceActorTests : TestKit
    {
        private IActorRef userActor;

        [SetUp]
        public void Setup()
        {
            userActor = Sys.ActorOf(Props.Create(() => new UserServiceActor()));
        }

        [Test]
        public void GetUserById_ReturnsCorrectUser()
        {
            var request = new GetUserById(1);

            var user = userActor.Ask<User>(request).Result;

            Assert.AreEqual("gary.oldman@example.com", user.Email);
        }
    }
}
