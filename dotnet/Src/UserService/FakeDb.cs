using System;
using System.Collections.Generic;
using UserService.Model;

namespace UserService
{
    internal static class FakeDb
    {
        internal static IEnumerable<User> Users = 
            new List<User>()
            {
                new User(1, "gary.oldman@example.com", "Gary", "Oldman"),
                new User(2, "jack.nicholson@example.com", "Jack", "Nicholson")
            };
    }
}
